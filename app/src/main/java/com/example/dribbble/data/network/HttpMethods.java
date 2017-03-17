package com.example.dribbble.data.network;

import com.example.dribbble.core.constants.DribbbleID;
import com.example.dribbble.data.local.user.UserHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.dribbble.core.constants.BaseUrl.BASE_URL;

/**
 * Created by qqq34 on 2017/3/8.
 */

public class HttpMethods {
    private static final int DEFAULT_TIMEOUT = 5;
    private DribbbleService mDribbbleService;
    private Retrofit retrofit;
    private HttpMethods() {
        OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
        localBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().client(localBuilder
                .addNetworkInterceptor(chain -> {
                    Request originalRequest = chain.request();
                    System.out.println(chain.request().url().url().toString());
                    Request authorised = originalRequest.newBuilder()
                            .build();
                        return chain.proceed(authorised);
                })
                .build())
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(BASE_URL).build();
        mDribbbleService = (retrofit.create(DribbbleService.class));
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public DribbbleService getDribbbleService() {
        return mDribbbleService;
    }

    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }
}
