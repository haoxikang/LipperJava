package com.fallllllll.lipper.data.network.interceptor;

import com.fallllllll.lipper.core.constants.DribbbleID;
import com.fallllllll.lipper.data.local.user.UserManager;
import com.fallllllll.lipper.utils.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 康颢曦 on 2017/3/20.
 */

public class LipperInterceptor implements Interceptor {


    public LipperInterceptor() {
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
