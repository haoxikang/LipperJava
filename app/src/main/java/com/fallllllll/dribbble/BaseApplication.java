package com.fallllllll.dribbble;

import android.app.Application;

import com.fallllllll.dribbble.dagger.AppComponent;
import com.fallllllll.dribbble.dagger.AppModule;
import com.fallllllll.dribbble.dagger.DaggerAppComponent;

/**
 * Created by Administrator on 2017/4/13/013.
 */

public class BaseApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public void setAppComponent(AppComponent appComponent) {
        mAppComponent = appComponent;
    }


}