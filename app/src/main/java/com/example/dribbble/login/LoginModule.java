package com.example.dribbble.login;

import com.example.dribbble.data.network.model.DribbbleModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by qqq34 on 2017/3/8.
 */

@Module
public class LoginModule {

    private LoginView mLoginView;

    public LoginModule(LoginView loginView) {
        mLoginView = loginView;
    }

    @Provides
    LoginPresenter provideLoginPresenter(DribbbleModel dribbbleModel) {
        return new LoginPresenter(dribbbleModel, mLoginView);
    }
}
