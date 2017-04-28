package com.fallllllll.lipper.utils;


import android.util.Log;

/**
 * Created by fallllllll on 2017/3/16.
 */

public class LogUtils {
    private static String tag = "LogUtils";
    private static boolean isCanLog = true;

    public static void i(String s) {
        if (isCanLog) {
            Log.i(tag, s);
        }


    }

    public static void w(String s) {
        if (isCanLog) {
            Log.w(tag, s);
        }
    }

    public static void d(String s) {
        if (isCanLog) {
            Log.d(tag, s);
        }
    }

    public static void e(String s) {
        if (isCanLog) {
            Log.e(tag, s);
        }
    }
}