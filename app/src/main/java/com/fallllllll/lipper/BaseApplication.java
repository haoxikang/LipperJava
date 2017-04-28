package com.fallllllll.lipper;

import android.app.Application;

import com.fallllllll.lipper.dagger.AppComponent;
import com.fallllllll.lipper.dagger.AppModule;
import com.fallllllll.lipper.dagger.DaggerAppComponent;

/**
 * Created by Administrator on 2017/4/13/013.
 */

public class BaseApplication extends Application {
    private AppComponent mAppComponent;
    private static BaseApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public void setAppComponent(AppComponent appComponent) {
        mAppComponent = appComponent;
    }


}
