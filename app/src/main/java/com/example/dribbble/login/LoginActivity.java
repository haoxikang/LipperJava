package com.example.dribbble.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.R;
import com.example.dribbble.core.activity.BaseActivity;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.databinding.ActivityLoginBinding;
import com.example.dribbble.utils.MDStatusBarCompat;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginView {
    ActivityLoginBinding mActivityLoginBinding;
    @Inject
    LoginPresenter mLoginPresenter;

    private LoginModule mLoginModule = new LoginModule(this);

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        MDStatusBarCompat.setImageTranslucent(this);
        mPresenterList.add(mLoginPresenter);
        Log.d("ddd","dddd");
    }

    @Override
    protected void initListeners() {



    }

    @Override
    protected void inject() {
        DaggerLoginComponent.builder().appComponent(((DribbbleApplication) getApplication())
                .getAppComponent())
                .loginModule(mLoginModule).build().inject(this);
    }

    public void setLoginModule(LoginModule loginModule){
       this.mLoginModule=loginModule;
    }

    @Override
    public void onDataFetch(ShotBean test) {
        showToast(test.getTitle());
    }
}
