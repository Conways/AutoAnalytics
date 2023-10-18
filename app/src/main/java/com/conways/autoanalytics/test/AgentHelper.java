package com.conways.autoanalytics.test;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

public class AgentHelper {

    public static void viewClick(View view){
        Log.d("zzzz", "viewClick: ");
    }
    public static void radioButtonClick(RadioGroup group, int checkedId){
        Log.d("zzzz", "radioButtonClick: ");
    }
    public static void checkBoxClick(CompoundButton buttonView, boolean isChecked){
        Log.d("zzzz", "checkBoxClick: ");
    }
    public static void agentRun(){
        Log.d("zzzz", "agentRun: ");
    }
    public static void dialogClick(DialogInterface dialogInterface,int witch){
        Log.d("zzzz", "(Landroid/content/DialogInterface;I)V: ");
    }

}
