package com.conways.autoanalytics.plugin.apm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public class ApmMethodVisitor extends AdviceAdapter {


    private final String nameDes;
    private int access;
    private String[] interfaces;
    private String des;
    private String owner;
    private String superName;
    private int timePos;
    private String name;

    protected ApmMethodVisitor(int api,
                               MethodVisitor methodVisitor,
                               int access,
                               String name,
                               String descriptor,
                               String className,
                               String[] interfaces,
                               String superName
    ) {
        super(api, methodVisitor, access, name, descriptor);
        this.nameDes = name + descriptor;
        this.name=name;
        this.access = access;
        this.interfaces = interfaces;
        this.des = descriptor;
        this.owner = className;
        this.superName=superName;
    }



    @Override
    protected void onMethodEnter() {
        if (Utils.isTargetMethod(nameDes)) {
            timePos=newLocal(Type.LONG_TYPE);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
            mv.visitVarInsn(LSTORE, timePos);
        }
        super.onMethodEnter();
    }

    @Override
    protected void onMethodExit(int opcode) {
        if (Utils.isTargetMethod(nameDes)) {
            mv.visitMethodInsn(INVOKESTATIC,
                    "java/lang/System",
                    "currentTimeMillis",
                    "()J");
            mv.visitVarInsn(LLOAD,timePos);
            mv.visitInsn(LSUB);
            mv.visitLdcInsn(name);
            mv.visitLdcInsn(owner);
            mv.visitVarInsn(ALOAD,0);
            mv.visitMethodInsn(INVOKEVIRTUAL,
                    "java/lang/Object",
                    "hashCode",
                    "()I",
                    false);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/conways/autoanalytics/sdk/apm/ApmAgent",
                    "apm",
                    "(JLjava/lang/String;Ljava/lang/String;I)V",
                    false);
        }
        super.onMethodExit(opcode);
    }
    @Override
    public void visitEnd() {
        super.visitEnd();
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack, maxLocals);
    }


}
