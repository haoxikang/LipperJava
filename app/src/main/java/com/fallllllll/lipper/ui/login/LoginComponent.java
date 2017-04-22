package com.fallllllll.lipper.ui.login;

import com.fallllllll.lipper.dagger.AppComponent;

import dagger.Component;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

@Component(dependencies = AppComponent.class,modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
