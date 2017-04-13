package com.example.dribbble.dagger;

import android.content.Context;

import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.OauthModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.data.network.model.impl.OauthModelImpl;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by 康颢曦 on 2017/3/8.
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
