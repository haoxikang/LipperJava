package com.example.dribbble.core.rxjava.exceptionalhandling;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.text.ParseException;

import retrofit2.HttpException;

/**
 * Created by qqq34 on 2017/3/13.
 */

public class NetworkException {
    public static ApiException handleException(Throwable e) {
        ApiException ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, ERROR.HTTP_ERROR);
            ex.HttpExceptionCode = ((HttpException) e).code();
            ex.message = e.getMessage();
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new ApiException(e, ERROR.PARSE_ERROR);
            ex.message = e.getMessage();
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.message = e.getMessage();
            return ex;
        } else {
            ex = new ApiException(e, ERROR.UNKNOWN);
            ex.message = e.getMessage();
            return ex;
        }
    }

}
