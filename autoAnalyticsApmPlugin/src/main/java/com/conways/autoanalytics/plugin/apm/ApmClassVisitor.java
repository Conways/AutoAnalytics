package com.conways.autoanalytics.plugin.apm;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


public class ApmClassVisitor extends ClassVisitor {

    private String superName;
    private String className;
    private String[] interfaces;



    public ApmClassVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
        this.interfaces = interfaces;
        this.superName = superName;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        return new ApmMethodVisitor(Opcodes.ASM6,
                methodVisitor,
                access,
                name,
                descriptor,
                className,
                interfaces,
                superName);
    }


}
