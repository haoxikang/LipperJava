package com.fallllllll.lipper.utils;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ApiException;
import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ERROR;
import com.fallllllll.lipper.data.local.user.UserManager;

/**
 * Created by fallllllll on 2017/4/28/028.
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
