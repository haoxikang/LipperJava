package com.fallllllll.lipper.ui.login;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;

import com.fallllllll.lipper.core.viewmodel.BaseViewModel;
import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.ui.main.MainActivity;

/**
 * Created by fallllllll on 2017/3/10.
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
        mContext.startActivity(intent);
    }

    @Override
    public void finishActivity() {
        ((Activity)mContext).finish();
    }
}
