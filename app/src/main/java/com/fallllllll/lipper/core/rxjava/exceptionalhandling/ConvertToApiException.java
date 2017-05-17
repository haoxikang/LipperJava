package com.fallllllll.lipper.core.rxjava.exceptionalhandling;

import com.fallllllll.lipper.core.exception.NetworkException;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * Created by fallllllll on 2017/3/13.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ConvertToApiException<T> implements Function<Throwable, Flowable<T>> {


    @Override
    public Flowable<T> apply(Throwable throwable) throws Exception {
        return Flowable.error(NetworkException.handleException(throwable));
    }
}
