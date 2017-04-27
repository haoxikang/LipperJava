package com.fallllllll.lipper.data.network;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public abstract class BaseHttpMethods<S> {
    private static final int DEFAULT_TIMEOUT = 15;
    private Retrofit retrofit;
    private S mService;


    public BaseHttpMethods(MyNetworkInterceptor myNetworkInterceptor) {
        mService = (createRetrofit(myNetworkInterceptor).create(getServiceClass()));

    }

    protected Retrofit createRetrofit(MyNetworkInterceptor myNetwrokInterceptor) {

////缓存文件夹
//        File cacheFile = new File(getExternalCacheDir().toString(),"cache");
////缓存大小为10M
//        int cacheSize = 10 * 1024 * 1024;
////创建缓存对象
//        Cache cache = new Cache(cacheFile,cacheSize);

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
