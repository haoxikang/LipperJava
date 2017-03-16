package com.example.dribbble.data.network;

import android.util.Log;

import com.example.dribbble.core.constants.DribbbleID;
import com.example.dribbble.user.UserToken;
import com.example.dribbble.user.UserUtils;
import com.example.dribbble.utils.LogUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
                    if (UserUtils.isLogin()) {
                        Request authorised = originalRequest.newBuilder()
                                .header("Authorization", UserUtils.getToken().getAccess_token())
                                .build();
                        return chain.proceed(authorised);
                    } else {
                        Request authorised = originalRequest.newBuilder()
                                .header("Authorization", DribbbleID.CLIENT_ACCESS_TOKEN)
                                .build();
                        return chain.proceed(authorised);
                    }
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
