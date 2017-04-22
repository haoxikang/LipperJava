package com.fallllllll.lipper;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2017/4/13/013.
 */

public class TestApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
