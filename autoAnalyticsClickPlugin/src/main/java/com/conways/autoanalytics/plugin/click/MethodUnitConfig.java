package com.conways.autoanalytics.plugin.click;

import org.objectweb.asm.Opcodes;

import java.util.HashMap;

public class MethodUnitConfig {

    public static final String AGENT_OWNER = "com/conways/autoanalytics/sdk/click/ClickDataAgent";

    public static HashMap<String, MethodUnit> clickMethods;


    public static final String CLICK_SPAN_ClASS = "android/text/style/ClickableSpan";
    public static final String CLICK_SPAN_METHOD = "onClick(Landroid/view/View;)V";

    /**
     * ClickableSpan
     */
    static {
        clickMethods = new HashMap<>();
        MethodUnit viewClick = new MethodUnit(
                0,
                "Landroid/view/View$OnClickListener;",
                "onClick",
                "(Landroid/view/View;)V",
                Opcodes.INVOKESTATIC,
                AGENT_OWNER,
                "viewClick",
                new int[]{Opcodes.ALOAD}
        );
        clickMethods.put(getKeyByUnit(viewClick), viewClick);

        MethodUnit radioButtonClick = new MethodUnit(
                1,
                "Landroid/widget/RadioGroup$OnCheckedChangeListener;",
                "onCheckedChanged",
                "(Landroid/widget/RadioGroup;I)V",
                Opcodes.INVOKESTATIC,
                AGENT_OWNER,
                "radioButtonClick",
                new int[]{Opcodes.ALOAD, Opcodes.ILOAD}
        );
        clickMethods.put(getKeyByUnit(radioButtonClick), radioButtonClick);
//
        MethodUnit checkBoxClick = new MethodUnit(
                2,
                "Landroid/widget/CompoundButton$OnCheckedChangeListener;",
                "onCheckedChanged",
                "(Landroid/widget/CompoundButton;Z)V",
                Opcodes.INVOKESTATIC,
                AGENT_OWNER,
                "checkBoxClick",
                new int[]{Opcodes.ALOAD, Opcodes.ILOAD}
        );
        clickMethods.put(getKeyByUnit(checkBoxClick), checkBoxClick);


        MethodUnit dialogClick = new MethodUnit(
                3,
                "Landroid/content/DialogInterface$OnClickListener;",
                "onClick",
                "(Landroid/content/DialogInterface;I)V",
                Opcodes.INVOKESTATIC,
                AGENT_OWNER,
                "dialogClick",
                new int[]{Opcodes.ALOAD, Opcodes.ILOAD}
        );
        clickMethods.put(getKeyByUnit(dialogClick), dialogClick);
    }

    public static String getKeyByUnit(MethodUnit unit) {
        return unit.getOwner() + unit.getName();
    }


}
