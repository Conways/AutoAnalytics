package com.conways.autoanalytics.sdk.click;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.conways.autoanalytics.sdk.click.entity.ClickData;

public class ClickDataAgent {

    public static void viewClick(View view) {
        ClickData data = ClickDataFactory.createClickData(view);
        ClickDataUtil.logMsg("auto_analytics_click", data.toString());

    }

    public static void radioButtonClick(RadioGroup group, int checkedId) {
        ClickData data = ClickDataFactory.createClickData(group);
        ClickDataUtil.logMsg("auto_analytics_click", data.toString());
    }

    public static void checkBoxClick(CompoundButton buttonView, boolean isChecked) {
        ClickData data = ClickDataFactory.createClickData(buttonView);
        ClickDataUtil.logMsg("auto_analytics_click", data.toString());
    }

    public static void dialogClick(DialogInterface dialogInterface, int witch) {
        ClickDataUtil.logMsg("auto_analytics_click", "dialogClick");
    }

}
