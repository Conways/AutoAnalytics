package com.conways.autoanalytics.plugin.bfclick;

import org.objectweb.asm.Opcodes;

import java.util.HashMap;

public class MethodUnitConfig {

    public static final String AGENT_OWNER = "com/conways/autoanalytics/sdk/bfclick/BFClickDataAgent";
    public static final String AGENT_METHOD = "isForceClick";

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

    }

    public static String getKeyByUnit(MethodUnit unit) {
        return unit.getOwner() + unit.getName();
    }


}
