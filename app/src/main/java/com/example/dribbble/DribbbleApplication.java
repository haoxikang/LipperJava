package com.example.dribbble;

import android.app.Application;
import android.content.Context;

import com.example.dribbble.dagger.AppComponent;
import com.example.dribbble.dagger.AppModule;
import com.example.dribbble.dagger.DaggerAppComponent;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.local.user.UserManager;
import com.facebook.drawee.backends.pipeline.Fresco;

import io.realm.Realm;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public class DribbbleApplication extends Application {


    @Override
    public void onCreate() {
        Realm.init(this);
        UserManager.INSTANCE.init();
        super.onCreate();
        Fresco.initialize(this);
    }


}
