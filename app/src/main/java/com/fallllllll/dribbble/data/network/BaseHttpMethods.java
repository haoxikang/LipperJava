package com.fallllllll.dribbble.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public abstract class BaseHttpMethods<S> {
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;
    private S mService;


    public BaseHttpMethods(MyNetworkInterceptor myNetworkInterceptor) {
        mService = (createRetrofit(myNetworkInterceptor).create(getServiceClass()));

    }

    protected Retrofit createRetrofit(MyNetworkInterceptor myNetwrokInterceptor) {


        OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
        localBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return retrofit = new Retrofit.Builder().client(localBuilder
                .addNetworkInterceptor(myNetwrokInterceptor)
                .build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(getBaseUrl())
                .build();
    }

    public S getService() {
        return mService;
    }

    abstract Class<S> getServiceClass();

    abstract String getBaseUrl();

}