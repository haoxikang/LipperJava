package com.example.dribbble;

import android.app.Application;

import com.example.dribbble.dagger.AppComponent;
import com.example.dribbble.dagger.AppModule;
import com.example.dribbble.dagger.DaggerAppComponent;

/**
 * Created by Administrator on 2017/4/13/013.
 */

public class DaggerApplication extends Application {
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
