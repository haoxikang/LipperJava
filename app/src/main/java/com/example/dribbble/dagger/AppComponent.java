package com.example.dribbble.dagger;

import android.content.Context;

import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.login.LoginActivity;

import dagger.Component;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

@Component(modules = {AppModule.class})
public interface AppComponent {
    DribbbleModel drbbbleModel();

    Context context();

}
