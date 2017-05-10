package com.fallllllll.lipper.data.network;

import com.fallllllll.lipper.BaseApplication;
import com.fallllllll.lipper.data.network.interceptor.LipperInterceptor;
import com.fallllllll.lipper.data.network.interceptor.LogInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fallllllll on 2017/3/8.
 */

public abstract class BaseHttpMethods<S> {
    private static final int DEFAULT_TIMEOUT = 15;
    private Retrofit retrofit;
    private S mService;


    public BaseHttpMethods() {
        mService = (createRetrofit().create(getServiceClass()));

    }

    protected Retrofit createRetrofit() {

        File cacheFile = new File(BaseApplication.getInstance().getExternalCacheDir().toString()+ "/okhttpCache", "lipper");
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(cacheFile, cacheSize);

        OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
        localBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return retrofit = new Retrofit.Builder().client(localBuilder
                .cache(cache)
                .addNetworkInterceptor(new LipperInterceptor())
                .addNetworkInterceptor(new LogInterceptor())
                .build())
                .addConverterFactory(GsonConverterFactory.create(BaseApplication.getInstance().getGson()))
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
