package com.conways.autoanalytics.sdk.apm;


import android.util.Log;

public class ApmAgent {

    public static void apm(long timeCost, String methodName, String className, int hashCode) {
        Log.d("auto_analytics_click",
                "timeCost: " + timeCost + "\n" +
                        "methodName: " + methodName + "\n" +
                        "className: " + className + "\n" +
                        "hashCode: " + hashCode + "\n");

    }

}
