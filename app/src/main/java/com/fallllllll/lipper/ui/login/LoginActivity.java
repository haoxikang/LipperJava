package com.fallllllll.lipper.ui.login;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.fallllllll.lipper.BaseApplication;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.activity.BaseActivity;
import com.fallllllll.lipper.ui.main.home.ShotsActivity;
import com.fallllllll.lipper.utils.MDStatusBarCompat;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.LoginView {

    public static final int LOGIN_REQUEST_CODE = 100;
    public static final String LOGIN_CODE_KEY = "LoginActivity.code.key";


    @Inject
    LoginContract.LoginPresenter loginPresenter;


    private LoginModule mLoginModule;
    private FloatingActionButton mRotateButton;
    private Button mLoginButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void initViewAndData() {
        if (mLoginModule == null) {
            mLoginModule = new LoginModule(this);
        }
        DaggerLoginComponent.builder().appComponent(((BaseApplication) getApplication())
                .getAppComponent())
                .loginModule(mLoginModule).build().inject(this);
        presenterLifecycleHelper.addPresenter(loginPresenter);
        setContentView(R.layout.activity_login);
        MDStatusBarCompat.setImageTranslucent(this);
        mRotateButton = (FloatingActionButton) findViewById(R.id.rotate_button);
        mLoginButton = (Button) findViewById(R.id.login_button);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_layout);

        mRotateButton.post(this::startAnimation);
        presenterLifecycleHelper.onPresenterCreate();
    }


    @Override
    protected void initListeners() {
        mLoginButton.setOnClickListener(v -> loginPresenter.onLoginClick());

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
                    loginPresenter.getUserData(Uri.parse(url).getQueryParameter("code"));
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public void goWebActivityForResult() {
        startActivityForResult(new Intent(this, LoginWebActivity.class), LOGIN_REQUEST_CODE);
    }

    @Override
    public void setButtonEnable(boolean isEnable) {
        mLoginButton.setEnabled(isEnable);
    }

    @Override
    public void goMainActivity() {
        Intent intent = new Intent(this, ShotsActivity.class);
        startActivity(intent);
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
