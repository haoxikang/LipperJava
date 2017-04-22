package com.fallllllll.lipper.data.network;

import com.fallllllll.lipper.core.constants.BaseUrl;
import com.fallllllll.lipper.data.network.service.DribbbleService;

/**
 * Created by 康颢曦 on 2017/3/20.
 */

public class DribbbleHttpMethods extends BaseHttpMethods<DribbbleService> {

    private static DribbbleHttpMethods instance;



    public static DribbbleHttpMethods getInstance() {
        return setupCreate();
    }

    private static DribbbleHttpMethods setupCreate() {

        if (instance == null) {
            synchronized (DribbbleHttpMethods.class) {
                if (instance == null) {
                        instance = new DribbbleHttpMethods(new MyNetworkInterceptor());

                }
            }
        }
        return instance;
    }

    public DribbbleHttpMethods(MyNetworkInterceptor myNetworkInterceptor) {
        super(myNetworkInterceptor);
    }
    @Override
    Class getServiceClass() {
        return DribbbleService.class;
    }

    @Override
    String getBaseUrl() {
        return BaseUrl.BASE_URL;
    }
}
