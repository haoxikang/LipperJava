package com.example.dribbble.dagger;

import android.content.Context;

import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by qqq34 on 2017/3/8.
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
    Context provideContext() {
        return mContext;
    }

}
