package com.example.dribbble.data.network;

import com.example.dribbble.core.constants.DribbbleID;
import com.example.dribbble.data.local.user.UserHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qqq34 on 2017/3/20.
 */

public class MyNetworkInterceptor implements Interceptor {

    private UserHelper mUserHelper;

    public MyNetworkInterceptor(UserHelper userHelper) {
        mUserHelper = userHelper;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        System.out.println(chain.request().url().url().toString());
        Request.Builder requestBuilder;
        if (mUserHelper.isLogin()) {
            requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer " + mUserHelper.getToken().getAccess_token());
        } else {
            requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer " + DribbbleID.CLIENT_ACCESS_TOKEN);
        }

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
