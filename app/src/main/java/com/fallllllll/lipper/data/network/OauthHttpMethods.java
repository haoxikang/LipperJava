package com.fallllllll.lipper.data.network;

import com.fallllllll.lipper.core.constants.BaseUrl;
import com.fallllllll.lipper.data.network.service.OauthService;

/**
 * Created by fallllllll on 2017/3/20.
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
                        instance = new OauthHttpMethods();
                }
            }
        }
        return instance;
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