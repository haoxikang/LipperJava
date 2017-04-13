package com.example.dribbble;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2017/4/13/013.
 */

public class TestApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
