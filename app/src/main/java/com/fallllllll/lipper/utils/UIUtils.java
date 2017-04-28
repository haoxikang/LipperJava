package com.fallllllll.lipper.utils;

import android.app.Activity;

/**
 * Created by fallllllll on 2017/4/22/022.
 */

public class UIUtils {
    public static int getStatusBarHeight(Activity activity){
        int statusBarHeight = -1;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
