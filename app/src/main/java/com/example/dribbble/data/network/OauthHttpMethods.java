package com.example.dribbble.data.network;

import com.example.dribbble.core.constants.BaseUrl;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.service.OauthService;

/**
 * Created by 康颢曦 on 2017/3/20.
 */

public class OauthHttpMethods extends BaseHttpMethods<OauthService> {


    private static OauthHttpMethods instance;


    public static OauthHttpMethods getInstance() {
        return setupCreate();
    }

    private static OauthHttpMethods setupCreate() {

        if (instance == null) {
            synchronized (OauthHttpMethods.class) {
                if (instance == null) {
                        instance = new OauthHttpMethods(new MyNetworkInterceptor());
                }
            }
        }
        return instance;
    }


    public OauthHttpMethods(MyNetworkInterceptor myNetworkInterceptor) {
        super(myNetworkInterceptor);
    }

    @Override
    Class getServiceClass() {
        return OauthService.class;
    }

    @Override
    String getBaseUrl() {
        return BaseUrl.LOGIN_URL;
    }
}
