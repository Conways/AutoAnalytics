package com.conways.autoanalytics.plugin.click;

import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

import java.util.Map;

public class ClickMethodVisitor extends AdviceAdapter {


    private final String nameDes;
    private int access;
    private String[] interfaces;
    private Map<String, MethodUnit> normalMethod;
    private String des;
    private String owner;
    private String superName;
    protected ClickMethodVisitor(int api,
                                 MethodVisitor methodVisitor,
                                 int access,
                                 String name,
                                 String descriptor,
                                 String className,
                                 String[] interfaces,
                                 Map<String, MethodUnit> lambdaMethod,
                                 String superName
    ) {
        super(api, methodVisitor, access, name, descriptor);
        this.nameDes = name + descriptor;
        this.access = access;
        this.interfaces = interfaces;
        this.normalMethod = lambdaMethod;
        this.des = descriptor;
        this.owner = className;
        this.superName=superName;
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        super.visitFieldInsn(opcode, owner, name, desc);
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();

        //处理clickSpan
        if (MethodUnitConfig.CLICK_SPAN_ClASS.equals(superName) && nameDes.equals(MethodUnitConfig.CLICK_SPAN_METHOD)) {
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            visitMethodInsn(Opcodes.INVOKESTATIC, MethodUnitConfig.AGENT_OWNER, "viewClick", "(Landroid/view/View;)V", false);
            return;
        }
        //处理lambda
        MethodUnit normalUnit = normalMethod.get(nameDes);
        if (null != normalUnit) {
            Type[] lambdaTypes = Type.getArgumentTypes(des);
            Type[] normalTypes = Type.getArgumentTypes(normalUnit.getDes());
            int argStartPos = lambdaTypes.length - normalTypes.length;
            if (argStartPos < 0) {
                return;
            }
            for (int i = 0; i < normalTypes.length; i++) {
                if (!lambdaTypes[i + argStartPos].equals(normalTypes[i])) {
                    return;
                }
            }
            for (int i = argStartPos; i < argStartPos + normalUnit.getLoadOpcodes().length; i++) {
                int opCode = normalUnit.getLoadOpcodes()[i - argStartPos];
                int varPos = findArgPos(lambdaTypes, i);
                visitVarInsn(opCode, varPos);
            }
            visitMethodInsn(normalUnit.getAgentOpcode(), normalUnit.getAgentOwner(), normalUnit.getAgentName(), normalUnit.getDes(), false);
            return;
        }

        //处理正常的
        for (MethodUnit temp : MethodUnitConfig.clickMethods.values()) {
            boolean isOwnerSame = false;
            for (int i = 0; i < interfaces.length; i++) {
                if (Type.getObjectType(interfaces[i]).getDescriptor().equals(temp.getOwner())) {
                    isOwnerSame = true;
                    break;
                }
            }
            boolean isNameDesSame = (temp.getName() + temp.getDes()).equals(nameDes);
            if (isOwnerSame && isNameDesSame) {
                int[] loadOpcodes = temp.getLoadOpcodes();
                for (int i = 0; i < loadOpcodes.length; i++) {
                    mv.visitVarInsn(loadOpcodes[i], i + 1);
                }
                visitMethodInsn(temp.getAgentOpcode(), temp.getAgentOwner(), temp.getAgentName(), temp.getDes(), false);
                break;
            }
        }
    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
    }
    @Override
    public void visitEnd() {
        normalMethod.remove(nameDes);
        super.visitEnd();
    }
    @Override
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        if (null != bsmArgs && bsmArgs.length > 2 && bsmArgs[1] instanceof Handle) {
            Handle lambdaArgs = (Handle) bsmArgs[1];
            String normalMethodKey = Type.getReturnType(desc).getDescriptor() + name;
            MethodUnit unit = MethodUnitConfig.clickMethods.get(normalMethodKey);
            if (null != unit) {
                String lambdaKey = lambdaArgs.getName() + lambdaArgs.getDesc();
                normalMethod.put(lambdaKey, unit);
            }
        }
        super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
    }


    private void logs(String methodName) {
        System.out.println("---" + methodName);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack, maxLocals);
    }


    private int findArgPos(Type[] types, int index) {
        if (types == null || index < 0 || index >= types.length) {
            throw new Error("getVisitPosition error");
        }
        if (index == 0) {
            return (access & Opcodes.ACC_STATIC) != 0 ? 0 : 1;
        } else {
            return findArgPos(types, index - 1) + types[index - 1].getSize();
        }
    }
}
