package com.fallllllll.dribbble.dagger;

import android.content.Context;

import com.fallllllll.dribbble.data.network.model.DribbbleModel;
import com.fallllllll.dribbble.data.network.model.OauthModel;
import com.fallllllll.dribbble.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

@Component(modules = {AppModule.class})
public interface AppComponent {
    DribbbleModel drbbbleModel();

    OauthModel oauthModel();

    Context context();

}
