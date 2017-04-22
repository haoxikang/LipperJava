package com.fallllllll.lipper.utils;

import java.util.logging.Logger;

/**
 * Created by 康颢曦 on 2017/3/16.
 */

public class LogUtils {
    private static String tag = "LogUtils";
    private static Logger logger = Logger.getLogger("LIPPER");
    private static boolean isCanLog = true;
    public static void i(String s){
        if (isCanLog){
            logger.info(s);
        }


    }
    public static void w(String s){
        if (isCanLog){
            logger.warning(s);
        }



    }
}
