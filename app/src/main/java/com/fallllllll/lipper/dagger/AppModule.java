package com.fallllllll.lipper.dagger;

import android.content.Context;

import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.network.model.OauthModel;
import com.fallllllll.lipper.data.network.model.impl.DribbbleModelImpl;
import com.fallllllll.lipper.data.network.model.impl.OauthModelImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fallllllll on 2017/3/8.
 */

@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;

    }

    @Provides
    public DribbbleModel provideDribbbleModel() {
        return DribbbleModelImpl.getInstance();
    }

    @Provides
    public OauthModel provideOauthModel(){
        return OauthModelImpl.getInstance();
    }



    @Provides
   public Context provideContext() {
        return mContext;
    }

}
