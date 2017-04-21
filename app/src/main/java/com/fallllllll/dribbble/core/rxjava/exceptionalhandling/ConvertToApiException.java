package com.fallllllll.dribbble.core.rxjava.exceptionalhandling;

import com.fallllllll.dribbble.core.exception.NetworkException;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * Created by 康颢曦 on 2017/3/13.
 */

public class ConvertToApiException<T> implements Function<Throwable, Flowable<T>> {


    @Override
    public Flowable<T> apply(Throwable throwable) throws Exception {
        return Flowable.error(NetworkException.handleException(throwable));
    }
}
