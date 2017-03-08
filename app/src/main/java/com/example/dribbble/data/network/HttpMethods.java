package com.example.dribbble.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qqq34 on 2017/3/8.
 */

public class HttpMethods {
    public static final String BASE_URL = "https://api.dribbble.com/v1/";
    private static final int DEFAULT_TIMEOUT = 5;
    private DribbbleService mDribbbleService;
    private Retrofit retrofit;

    private HttpMethods()
    {
        OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
        localBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().client(localBuilder.build()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(BASE_URL).build();
        mDribbbleService = (retrofit.create(DribbbleService.class));
    }

    public static HttpMethods getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public DribbbleService getDribbbleService()
    {
        return mDribbbleService;
    }

    private static class SingletonHolder
    {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }
}
