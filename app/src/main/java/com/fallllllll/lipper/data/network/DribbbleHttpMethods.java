package com.fallllllll.lipper.data.network;

import com.fallllllll.lipper.core.constants.BaseUrl;
import com.fallllllll.lipper.data.network.service.DribbbleService;

/**
 * Created by fallllllll on 2017/3/20.
 * GitHub :  https://github.com/348476129/Lipper
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
                        instance = new DribbbleHttpMethods();

                }
            }
        }
        return instance;
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
