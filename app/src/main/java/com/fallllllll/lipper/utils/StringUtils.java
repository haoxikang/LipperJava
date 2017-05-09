package com.fallllllll.lipper.utils;


import android.text.TextUtils;

/**
 * Created by Administrator on 2017/5/3/003.
 */

public class StringUtils {
    public static String numberToK(String string) {
        if (!TextUtils.isEmpty(string) && TextUtils.isDigitsOnly(string)) {
            int a = Integer.parseInt(string);
            if (a > 999) {
                return a / 1000 + "k";
            }
            return string;
        } else return string;
    }
}
