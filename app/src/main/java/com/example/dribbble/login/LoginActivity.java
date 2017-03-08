package com.example.dribbble.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.R;
import com.example.dribbble.core.activity.BaseActivity;
import com.example.dribbble.databinding.ActivityLoginBinding;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginView {
    ActivityLoginBinding mActivityLoginBinding;
    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        DaggerLoginComponent.builder().appComponent(((DribbbleApplication) getApplication())
                .getAppComponent())
                .loginModule(new LoginModule(this)).build().inject(this);
        mPresenterList.add(mLoginPresenter);
    }

    @Override
    protected void initListeners() {

    }
}
