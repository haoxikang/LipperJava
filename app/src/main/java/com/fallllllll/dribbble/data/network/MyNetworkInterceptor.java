package com.fallllllll.dribbble.data.network;

import com.fallllllll.dribbble.core.constants.DribbbleID;
import com.fallllllll.dribbble.data.local.user.UserManager;
import com.fallllllll.dribbble.utils.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 康颢曦 on 2017/3/20.
 */

public class MyNetworkInterceptor implements Interceptor {


    public MyNetworkInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        LogUtils.i(chain.request().url().url().toString());
        Request.Builder requestBuilder;
        if (UserManager.INSTANCE.getUserToken()!=null) {
            requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer " + UserManager.INSTANCE.getUserToken().getAccess_token());
        } else {
            requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer " + DribbbleID.CLIENT_ACCESS_TOKEN);
        }

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
