package com.example.dribbble.login;

import android.content.Context;

import com.example.dribbble.core.presenter.Contract;
import com.example.dribbble.core.viewmodel.BaseViewModel;
import com.example.dribbble.data.databean.ShotBean;

/**
 * Created by qqq34 on 2017/3/10.
 */

public class LoginViewModel extends BaseViewModel implements LoginView {

    public LoginViewModel(Context context) {
        super(context);
    }

    @Override
    public void onDataFetch(ShotBean test) {

    }
}
