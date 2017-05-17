package com.fallllllll.lipper.dagger;

import android.content.Context;

import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.network.model.OauthModel;

import dagger.Component;

/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
 */

@Component(modules = {AppModule.class})
public interface AppComponent {
    DribbbleModel drbbbleModel();

    OauthModel oauthModel();

    Context context();

}
