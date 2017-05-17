package com.fallllllll.lipper.ui.login;

import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.network.model.OauthModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
 */

@Module
public class LoginModule {

    private LoginContract.LoginView mLoginView;

    public LoginModule(LoginContract.LoginView loginView) {
        mLoginView = loginView;
    }

    @Provides
    LoginContract.LoginPresenter provideLoginPresenter(DribbbleModel dribbbleModel, OauthModel oauthModel) {
        return new LoginPresenterImpl(dribbbleModel,oauthModel, mLoginView);
    }
}
