package com.fallllllll.lipper;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.fallllllll.lipper.dagger.AppComponent;
import com.fallllllll.lipper.dagger.AppModule;
import com.fallllllll.lipper.dagger.DaggerAppComponent;
import com.fallllllll.lipper.data.local.datatank.DataTank;
import com.fallllllll.lipper.data.local.datatank.GsonAdapter;
import com.fallllllll.lipper.data.local.user.UserManager;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by fallllllll on 2017/4/13/013.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class BaseApplication extends Application {
    private AppComponent mAppComponent;
    private static BaseApplication instance;
    private Gson gson= new Gson();
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            DataTank.init(getCacheDir().getPath(), 2048000, new GsonAdapter(getGson()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        UserManager.INSTANCE.init();
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
