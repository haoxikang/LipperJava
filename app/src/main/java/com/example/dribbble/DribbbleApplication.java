package com.example.dribbble;

import android.app.Application;
import android.content.Context;

import com.example.dribbble.dagger.AppComponent;
import com.example.dribbble.dagger.AppModule;
import com.example.dribbble.dagger.DaggerAppComponent;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by qqq34 on 2017/3/8.
 */

public class DribbbleApplication extends Application {


    private AppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();

        Fresco.initialize(this);

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
    public void setAppComponent(AppComponent appComponent) {
        mAppComponent = appComponent;
    }

}
