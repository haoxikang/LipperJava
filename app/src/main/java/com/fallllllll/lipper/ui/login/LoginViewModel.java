package com.fallllllll.lipper.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;

import com.fallllllll.lipper.core.viewmodel.BaseViewModel;
import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.ui.main.home.ShotsActivity;

/**
 * Created by fallllllll on 2017/3/10.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class LoginViewModel extends BaseViewModel implements LoginContract.LoginView {

    public final ObservableField<Boolean> isEnable = new ObservableField<>(true);

    public LoginViewModel(Context context) {
        super(context);
    }



    @Override
    public void goWebActivityForResult() {

    }

    @Override
    public void setButtonEnable(boolean isEnable) {
        this.isEnable.set(isEnable);
    }

    @Override
    public void goMainActivity() {
        Intent intent = new Intent(mContext, ShotsActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void finishActivity() {
        ((Activity)mContext).finish();
    }
}
