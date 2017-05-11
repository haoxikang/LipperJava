package com.fallllllll.lipper;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.fallllllll.lipper.dagger.AppComponent;
import com.fallllllll.lipper.dagger.AppModule;
import com.fallllllll.lipper.dagger.DaggerAppComponent;
import com.google.gson.Gson;

/**
 * Created by fallllllll on 2017/4/13/013.
 */

public class BaseApplication extends Application {
    private AppComponent mAppComponent;
    private static BaseApplication instance;
    private Gson gson= new Gson();
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
        initFresco();
    }
    private void initFresco(){
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true).build();
        Fresco.initialize(this,config);
    }

    public Gson getGson() {
        return gson;
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
