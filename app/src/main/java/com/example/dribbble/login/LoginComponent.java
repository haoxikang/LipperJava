package com.example.dribbble.login;

import com.example.dribbble.dagger.AppComponent;

import dagger.Component;

/**
 * Created by qqq34 on 2017/3/8.
 */

@Component(dependencies = AppComponent.class,modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
