package com.example.dribbble.core.rxjava.exceptionalhandling;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by qqq34 on 2017/3/13.
 */

public class HttpResponseFunc<T> implements Function<Throwable, Flowable<T>> {


    @Override
    public Flowable<T> apply(Throwable throwable) throws Exception {
        return Flowable.error(NetworkException.handleException(throwable));
    }
}
