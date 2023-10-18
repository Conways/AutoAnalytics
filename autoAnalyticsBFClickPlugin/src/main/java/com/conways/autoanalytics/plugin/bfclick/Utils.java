package com.conways.autoanalytics.plugin.bfclick;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.regex.Matcher;

public class Utils {


    /**
     * 检测工程类
     *
     * @param fileName .class file
     * @return
     */
    public static boolean isTargetClass(String fileName) {
        return  path2ClassName(fileName).contains("com.conways.autoanalytics.test.SplashActivity");
    }


    public static boolean isTargetMethod(String nameDes,int acc) {
        return true;
    }


    public static File modifyJar(File jarFile, File tempDir, boolean nameHex) throws IOException {
        JarFile file = new JarFile(jarFile, false);
        String hexName = "";
        if (nameHex) {
            hexName = DigestUtils.md5Hex(jarFile.getAbsolutePath()).substring(0, 8);
        }
        File outputJar = new File(tempDir, hexName + jarFile.getName());
        JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(outputJar));
        Enumeration enumeration = file.entries();
        while (enumeration.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) enumeration.nextElement();
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream(jarEntry);
            } catch (Exception e) {
                return null;
            }
            String entryName = jarEntry.getName();
            if (entryName.endsWith(".DSA") || entryName.endsWith(".SF")) {
                //ignore
            } else {
                String className;
                JarEntry jarEntry2 = new JarEntry(entryName);
                jarOutputStream.putNextEntry(jarEntry2);

                byte[] modifiedClassBytes = null;
                byte[] sourceClassBytes = IOUtils.toByteArray(inputStream);
                if (entryName.endsWith(".class")) {
                    className = entryName
                            .replace(Matcher.quoteReplacement(File.separator), ".")
                            .replace(".class", "");
                    if (isTargetClass(className)) {
                        modifiedClassBytes = modifyClass(sourceClassBytes);
                    }
                }
                if (modifiedClassBytes == null) {
                    modifiedClassBytes = sourceClassBytes;
                }
                jarOutputStream.write(modifiedClassBytes);
                jarOutputStream.closeEntry();
            }
        }
        jarOutputStream.close();
        file.close();
        return outputJar;
    }


    public static File modifyClassFile(File dir, File classFile, File tempDir) {
        File modified = null;
        try {
            String className = path2ClassName(classFile.getAbsolutePath().replace(dir.getAbsolutePath() + File.separator, ""));
            byte[] sourceClassBytes = IOUtils.toByteArray(Files.newInputStream(classFile.toPath()));
            byte[] modifiedClassBytes = modifyClass(sourceClassBytes);
            if (null != modifiedClassBytes) {
                modified = new File(tempDir, className.replace(".", "") + ".class");
                if (modified.exists()) {
                    modified.delete();
                }
                modified.createNewFile();
                new FileOutputStream(modified).write(modifiedClassBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            modified = classFile;
        }
        return modified;
    }


    public static void insertBFClick(MethodVisitor methodVisitor){
        methodVisitor.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                MethodUnitConfig.AGENT_OWNER,
                MethodUnitConfig.AGENT_METHOD,
                "(Landroid/view/View;)Z",
                false);
        Label label=new Label();
        methodVisitor.visitJumpInsn(Opcodes.IFEQ,label);
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitLabel(label);
    }


    private static byte[] modifyClass(byte[] srcClass) throws IOException {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor classVisitor = new BFClickClassVisitor(Opcodes.ASM6, classWriter);
        ClassReader cr = new ClassReader(srcClass);
        cr.accept(classVisitor, ClassReader.SKIP_FRAMES);
        return classWriter.toByteArray();
    }


    private static String path2ClassName(String pathName) {
        return pathName
                .replace(File.separator, ".")
                .replace(".class", "");
    }




}
