package com.example.dribbble.login;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.R;
import com.example.dribbble.core.activity.BaseActivity;
import com.example.dribbble.databinding.ActivityLoginBinding;
import com.example.dribbble.utils.MDStatusBarCompat;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

    public static final int LOGIN_REQUEST_CODE = 100;
    public static final String LOGIN_CODE_KEY = "LoginActivity.code.key";


    private LoginViewModel mLoginViewModel;

    ActivityLoginBinding mActivityLoginBinding;
    @Inject
    LoginPresenter mLoginPresenter;


    private LoginModule mLoginModule;
    private FloatingActionButton mRotateButton;
    private Button mLoginButton;
    private RelativeLayout mRelativeLayout;


    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mLoginViewModel = new LoginViewModel(this);
        if (mLoginModule == null) {
            mLoginModule = new LoginModule(mLoginViewModel);
        }
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        MDStatusBarCompat.setImageTranslucent(this);


        mRotateButton = mActivityLoginBinding.rotateButton;
        mLoginButton = mActivityLoginBinding.loginButton;

        mRelativeLayout = mActivityLoginBinding.rlLayout;

    mRotateButton.post(() -> startAnimation());

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void initListeners() {


        mLoginButton.setOnClickListener(v -> {
         mLoginPresenter.onLoginClick();
        });

    }

    @Override
    protected void inject() {
        DaggerLoginComponent.builder().appComponent(((DribbbleApplication) getApplication())
                .getAppComponent())
                .loginModule(mLoginModule).build().inject(this);
        mPresenterList.add(mLoginPresenter);
    }

    public void setLoginModule(LoginModule loginModule) {
        this.mLoginModule = loginModule;
    }


    private void startAnimation() {

        int duration = 700;
        int maxValue = 1000;

        float distanceRotateButton = beforeRotateButtonAnimation();
        float distanceLoginButton = beforeLoginButtonAnimation();


        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, maxValue);
        valueAnimator.setInterpolator(new OvershootInterpolator(0.8f));
        valueAnimator.addUpdateListener(animation -> {
            float value = (Float) animation.getAnimatedValue();
            float YRotateButton = (0 - mRotateButton.getHeight()) + distanceRotateButton * value / maxValue;

            float YLoginButton = (mLoginButton.getHeight() + mRelativeLayout.getHeight()) - distanceLoginButton * value / maxValue;


            mRotateButton.setY(YRotateButton);
            mLoginButton.setY(YLoginButton);

            if (value == maxValue) {
                valueAnimator.removeAllUpdateListeners();
            }


        });

        valueAnimator.setDuration(duration).start();

    }

    private float beforeRotateButtonAnimation() {
        float rotateH = mRotateButton.getHeight();
        float rotateButtonY = mRotateButton.getY();
        float rotateButtonYs = 0 - rotateH;
        float distance = rotateButtonY - rotateButtonYs;
        mRotateButton.setY(rotateButtonYs);
        mRotateButton.setVisibility(View.VISIBLE);
        return distance;
    }

    private float beforeLoginButtonAnimation() {
        float layoutH = mRelativeLayout.getHeight();
        float buttonH = mLoginButton.getHeight();
        float buttonY = mLoginButton.getY();
        float buttonYs = layoutH + buttonH;
        float distance = buttonYs - buttonY;
        mLoginButton.setY(buttonYs);
        mLoginButton.setVisibility(View.VISIBLE);
        return distance;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    Bundle b = data.getExtras();
                    String url = b.getString(LOGIN_CODE_KEY);
                    Log.d("aaa", Uri.parse(url).getQueryParameter("code")  );
                    break;
                default:
                    break;
            }
        }

    }
}
