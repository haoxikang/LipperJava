package com.fallllllll.lipper.core.rxjava.exceptionalhandling;

/**
 * Created by 康颢曦 on 2017/3/13.
 */

public class ApiException extends Exception {
    public int code;
    public String message;
    public int HttpExceptionCode = -1;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;

    }
}