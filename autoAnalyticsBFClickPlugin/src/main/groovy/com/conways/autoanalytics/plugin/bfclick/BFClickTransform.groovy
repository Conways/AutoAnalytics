package com.conways.autoanalytics.plugin.bfclick;

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import groovy.io.FileType
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.io.FileUtils

class BFClickTransform extends Transform {



    @Override
    String getName() {
        return "autoAnalyticsBFClick"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        if (!transformInvocation.incremental) {
            transformInvocation.outputProvider.deleteAll()
        }
        transformInvocation.inputs.each { TransformInput input ->
            transformClass(transformInvocation, input)
            transformJar(transformInvocation, input)
        }

    }
    static void transformClass(TransformInvocation transformInvocation, TransformInput input) {
        input.directoryInputs.each { DirectoryInput directoryInput ->
            File transformDir = transformInvocation.outputProvider.getContentLocation(
                    directoryInput.name,
                    directoryInput.contentTypes,
                    directoryInput.scopes,
                    Format.DIRECTORY)
            FileUtils.copyDirectory(directoryInput.file, transformDir)
            File dir = directoryInput.file;
            if (dir) {
                HashMap<String, File> insertClass = new HashMap<>()
                dir.traverse(type: FileType.FILES, nameFilter: ~/.*\.class/) {
                    File javacFile ->
                        File insertResult = null;
                        if (Utils.isTargetClass(javacFile.absolutePath)) {
                            insertResult = Utils.modifyClassFile(dir, javacFile, transformInvocation.context.getTemporaryDir())
                        }
                        if (null != insertResult) {
                            String key = javacFile.absolutePath.replace(dir.absolutePath, "")
                            insertClass.put(key, insertResult)
                        }
                }
                insertClass.entrySet().each {
                    Map.Entry<String, File> en ->
                        File target = new File(transformDir.absolutePath + en.getKey())
                        if (target.exists()) {
                            target.delete()
                        }
                        FileUtils.copyFile(en.getValue(), target)
                        en.getValue().delete()
                }
            }
        }
    }
    static void transformJar(TransformInvocation transformInvocation, TransformInput input) {
        input.jarInputs.each { JarInput jarInput ->
            String jarName = jarInput.file.name
            def hexName = DigestUtils.md5Hex(jarInput.file.absolutePath).substring(0, 8)
            if (jarName.endsWith(".jar")) {
                jarName = jarName.substring(0, jarName.length() - 4)
            }
            File targetJar = transformInvocation.outputProvider.getContentLocation(jarName + "_" + hexName, jarInput.contentTypes, jarInput.scopes, Format.JAR)
            def modifiedJar = Utils.modifyJar(jarInput.file, transformInvocation.context.getTemporaryDir(), true);
            if (modifiedJar == null) {
                modifiedJar = jarInput.file
            }
            FileUtils.copyFile(modifiedJar, targetJar)

        }
    }

}