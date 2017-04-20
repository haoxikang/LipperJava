package com.example.dribbble.login;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;

import com.example.dribbble.core.presenter.Contract;
import com.example.dribbble.core.viewmodel.BaseViewModel;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.main.MainActivity;

/**
 * Created by 康颢曦 on 2017/3/10.
 */

public class LoginViewModel extends BaseViewModel implements LoginContract.LoginView {

    public final ObservableField<Boolean> isEnable = new ObservableField<>(true);

    public LoginViewModel(Context context) {
        super(context);
    }

    @Override
    public void onDataFetch(ShotBean test) {

    }

    @Override
    public void goWebActivityForResult() {
        ((LoginActivity) mContext).startActivityForResult(new Intent(mContext, LoginWebActivity.class), LoginActivity.LOGIN_REQUEST_CODE);
    }

    @Override
    public void setButtonEnable(boolean isEnable) {
        this.isEnable.set(isEnable);
    }

    @Override
    public void goMainActivity() {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) mContext).toBundle());
    }

    @Override
    public void finishActivity() {
        ((Activity)mContext).finish();
    }
}
