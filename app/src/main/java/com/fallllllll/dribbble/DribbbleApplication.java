package com.fallllllll.dribbble;

import com.fallllllll.dribbble.data.local.user.UserManager;
import com.facebook.drawee.backends.pipeline.Fresco;

import io.realm.Realm;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public class DribbbleApplication extends BaseApplication {


    @Override
    public void onCreate() {
        Realm.init(this);
        UserManager.INSTANCE.init();
        super.onCreate();
        Fresco.initialize(this);
    }


}
