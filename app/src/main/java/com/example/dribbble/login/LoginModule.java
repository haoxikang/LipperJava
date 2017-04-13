package com.example.dribbble.login;

import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.OauthModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

@Module
public class LoginModule {

    private LoginView mLoginView;

    public LoginModule(LoginView loginView) {
        mLoginView = loginView;
    }

    @Provides
    LoginPresenter provideLoginPresenter(DribbbleModel dribbbleModel, OauthModel oauthModel) {
        return new LoginPresenter(dribbbleModel,oauthModel, mLoginView);
    }
}
