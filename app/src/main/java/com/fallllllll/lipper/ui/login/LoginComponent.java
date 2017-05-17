package com.fallllllll.lipper.ui.login;

import com.fallllllll.lipper.dagger.AppComponent;

import dagger.Component;

/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
 */

@Component(dependencies = AppComponent.class,modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
