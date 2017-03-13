package com.example.dribbble.core.rxjava.exceptionalhandling;

/**
 * Created by qqq34 on 2017/3/13.
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