package com.fallllllll.lipper.utils;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.fallllllll.lipper.R;


/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
 */
public class MDStatusBarCompat {


    /**
     * 简单型状态栏(ToolBar)
     */
    public static void setOrdinaryToolBar(Activity activity) {
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.primary_dark));
    }

    /**
     * 图片全屏透明状态栏（图片位于状态栏下面）
     */
    public static void setImageTransparent(Activity activity) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    /**
     * 图片全屏半透明状态栏（图片位于状态栏下面）
     */
    public static void setImageTranslucent(Activity activity) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.statusBar));

    }




}
