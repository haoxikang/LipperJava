package com.example.dribbble.utils;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.example.dribbble.R;


/**
 * Created by qqq34 on 2017/3/8.
 */
public class MDStatusBarCompat {

    private static View mStatusBarView;

    /**
     * 简单型状态栏(ToolBar)
     *
     * @param activity
     */
    public static void setOrdinaryToolBar(Activity activity) {
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.primary_dark));
    }

    /**
     * 图片全屏透明状态栏（图片位于状态栏下面）
     *
     * @param activity
     */
    public static void setImageTransparent(Activity activity) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    /**
     * 图片全屏半透明状态栏（图片位于状态栏下面）
     *
     * @param activity
     */
    public static void setImageTranslucent(Activity activity) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.statusBar));

    }

    /**
     * ToolBar+TabLayout状态栏(ToolBar可伸缩)
     *
     * @param activity
     */
    public static void setToolbarTabLayout(Activity activity) {
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.primary_dark));
    }



}
