package com.conways.autoanalytics.sdk.click;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;

public class ClickDataUtil {


    public static String getPageCode(View view) {
        return getCurrentPageMsg(view.getContext(), view);
    }


    /**
     * 页面列表 顺序集合
     */
    public static String getPageList(View view) {
        return view.getContext().getClass().getName();
    }

    /**
     * 组件名称
     */
    public static String getComponentName(View view) {
        return view.getClass().getName();
    }

    /**
     * 点击文案
     */
    public static String getClickText(View view) {
        return getContentMsg(view);
    }


    /**
     * 获取当前页面全称，com.**.**.Activity/Fragment
     * 可能是activity也可能是fragment
     *
     * @param context
     * @param view
     * @return
     */
    private static String getCurrentPageMsg(Context context, View view) {


        if (context instanceof FragmentActivity) {
            List<Fragment> fragments =
                    ((FragmentActivity) context).getSupportFragmentManager().getFragments();
            if (fragments.size() < 1) {
                return context.getClass().getName();
            }
            String packageMsg = context.getClass().getName();
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                View tempView = fragment.getView();
                if (tempView instanceof ViewGroup && contain((ViewGroup) tempView, view)) {
                    packageMsg = fragment.getClass().getName();
                    String childPackageMsg = getCurrentFragment(fragment, view);
                    if (!TextUtils.isEmpty(childPackageMsg)) {
                        packageMsg = childPackageMsg;
                    }
                    break;
                }
            }
            return packageMsg;
        }
        return context.getClass().getName();
    }


    private static String getCurrentFragment(Fragment fragment, View view) {
        String msg = "";
        List<Fragment> childFragments = fragment.getChildFragmentManager().getFragments();
        if (childFragments.isEmpty()) {
            return msg;
        }
        for (int i = 0; i < childFragments.size(); i++) {
            Fragment tempFragment = childFragments.get(i);
            View tempView = tempFragment.getView();
            if (tempView instanceof ViewGroup && contain((ViewGroup) tempView, view)) {
                msg = tempFragment.getClass().getName();
                String temp = getCurrentFragment(tempFragment, view);
                if (!TextUtils.isEmpty(temp)) {
                    msg = temp;
                }
                break;
            }
        }
        return msg;
    }


    private static boolean contain(ViewGroup p, View c) {
        boolean contain = false;
//        Log.d("auto_analytics_click", p.getClass().getSimpleName());
        for (int i = 0; i < p.getChildCount(); i++) {
            if (p.getChildAt(i) == c) {
                contain = true;
                break;
            }
            if (p.getChildAt(i) instanceof ViewGroup) {
                contain = contain((ViewGroup) p.getChildAt(i), c);
                if (contain) {
                    break;
                }
            }
        }
        return contain;
    }

    /**
     * 解析文字内容
     *
     * @param view
     * @return
     */
    private static String getContentMsg(View view) {
        String msg = "";
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                String temp = getContentMsg(((ViewGroup) view).getChildAt(i));
                if (!TextUtils.isEmpty(temp)) {
                    msg = msg + "_" + temp;
                }
            }
        }
        if (view.getVisibility() != View.VISIBLE) {
            return msg;
        }
        if (view instanceof TextView) {
            String temp = ((TextView) view).getText().toString();
            msg = msg + "_" + temp;
        }
        if (view instanceof Button) {
            String temp = ((Button) view).getText().toString();
            msg = msg + "_" + temp;
        }
        return msg;
    }

    public static String getParentMsg(View view) {
        String msg = view.getClass().getName() + "\n";
        if (null != view.getParent()) {
            msg = msg + getParentMsg(view.getParent());
        }
        return msg;
    }


    private static String getParentMsg(ViewParent viewParent) {
        String msg = viewParent.getClass().toString() + "\n";
        if (null != viewParent.getParent()) {
            msg = msg + getParentMsg(viewParent.getParent());
        }
        return msg;
    }

    public static String getIdNameById(Context context, int id) {
        if (null == context || id < 0) {
            return "";
        }
        Resources resources = context.getResources();
        if (null == resources) {
            return "";
        }
        try {
            return resources.getResourceEntryName(id);
        } catch (Resources.NotFoundException e) {
            return "";
        }
    }

    /**
     * 打印日志
     *
     * @param tag
     * @param msg
     */
    public static void logMsg(String tag, String msg) {
        Log.d(tag, msg);
    }


}
