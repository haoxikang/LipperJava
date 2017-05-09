package com.fallllllll.lipper;

import com.fallllllll.lipper.data.local.datatank.DataTank;
import com.fallllllll.lipper.data.local.datatank.GsonAdapter;
import com.fallllllll.lipper.data.local.user.UserManager;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.IOException;


/**
 * Created by fallllllll on 2017/3/8.
 */

public class DribbbleApplication extends BaseApplication {


    @Override
    public void onCreate() {
        try {
            DataTank.init(getCacheDir().getPath(), 2048000, new GsonAdapter(getGson()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        UserManager.INSTANCE.init();
        super.onCreate();
        Fresco.initialize(this);
    }


}
