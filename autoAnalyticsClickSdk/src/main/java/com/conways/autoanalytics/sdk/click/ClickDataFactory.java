package com.conways.autoanalytics.sdk.click;

import android.view.View;

import com.conways.autoanalytics.sdk.click.entity.ClickData;

public class ClickDataFactory {


    public static ClickData createClickData(View view) {
        ClickData data = ClickData.AutoAnalyticsDataBuilder.anAutoAnalyticsData()
                .pageCode(ClickDataUtil.getPageCode(view))
                .pageList(ClickDataUtil.getPageList(view))
                .componentName(ClickDataUtil.getComponentName(view))
                .clickText(ClickDataUtil.getClickText(view))
                .parentMsg(ClickDataUtil.getParentMsg(view))
                .viewIdName(ClickDataUtil.getIdNameById(view.getContext(), view.getId()))
                .build();
        return data;
    }


}
