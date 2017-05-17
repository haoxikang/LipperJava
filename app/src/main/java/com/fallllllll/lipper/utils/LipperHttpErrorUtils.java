package com.fallllllll.lipper.utils;

import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ApiException;
import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ERROR;

/**
 * Created by fallllllll on 2017/4/28/028.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class LipperHttpErrorUtils {
    public static boolean checkTooManyRequest(Throwable throwable) {
        if (throwable instanceof ApiException) {
            ApiException apiException = (ApiException) throwable;
            if (apiException.HttpExceptionCode == ERROR.HTTP_ERROR) {
                if (apiException.code == 423) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkToken(Throwable throwable) {
        if (throwable instanceof ApiException) {
            ApiException apiException = (ApiException) throwable;
            if (apiException.code == ERROR.HTTP_ERROR && apiException.HttpExceptionCode == 401) {
                return true;
            }
        }
        return false;
    }
}
