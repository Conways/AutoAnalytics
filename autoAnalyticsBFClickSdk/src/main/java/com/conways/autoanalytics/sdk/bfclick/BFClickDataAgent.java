package com.conways.autoanalytics.sdk.bfclick;

import android.view.View;

public class BFClickDataAgent {


    public static int lastViewHashCode = -1;

    public static long lastClickTime = -1L;


    public static boolean isForceClick(View view) {
        if (null == view) {
            return false;
        }
        if (lastViewHashCode != view.hashCode()) {
            lastClickTime = System.currentTimeMillis();
            lastViewHashCode = view.hashCode();
            return false;
        }
        if (System.currentTimeMillis() - lastClickTime > 2000L) {
            lastClickTime = System.currentTimeMillis();
            lastViewHashCode = view.hashCode();
            return false;
        }
        return true;
    }


}
