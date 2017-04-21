package com.fallllllll.dribbble.core.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.fallllllll.dribbble.R;
import com.fallllllll.dribbble.core.presenter.Contract;
import com.tapadoo.alerter.Alert;
import com.tapadoo.alerter.Alerter;

/**
 * Created by 康颢曦 on 2017/3/10.
 */

public  class BaseViewModel implements Contract.BaseView {
    public Context mContext;
    private Alert alert;

    public BaseViewModel(Context context) {
        mContext = context;
    }


    @Override
    public void showToast(String s) {
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTopDialog(String s) {
        hideAllTopDialog();
        alert = Alerter.create((Activity)mContext)
                .setText(s)
                .setDuration(Integer.MAX_VALUE)
                .setOnClickListener(v -> {

                })
                .show();
    }

    @Override
    public void hideAllTopDialog() {
        if (alert!=null&&alert.isShown()){
            alert.hide();
        }
    }

    @Override
    public void showErrorDialog(String s) {
        hideAllTopDialog();
        alert = Alerter.create((Activity)mContext)
                .setText(s)
                .setBackgroundColor(R.color.accent)
                .setDuration(2000)
                .show();
    }

    @Override
    public String getString(int res) {
        return mContext.getString(res);
    }
}