package com.fallllllll.lipper.core.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.utils.BaseViewUtils;
import com.tapadoo.alerter.Alert;
import com.tapadoo.alerter.Alerter;

/**
 * Created by fallllllll on 2017/3/10.
 */

public class BaseViewModel implements Contract.BaseView {
    public Context mContext;
    private BaseViewUtils baseViewUtils;

    public BaseViewModel(Context context) {
        mContext = context;
        baseViewUtils = new BaseViewUtils(context);
    }


    @Override
    public void showToast(String s) {
        baseViewUtils.showToast(s);
    }

    @Override
    public void showTopDialog(String s) {
        baseViewUtils.showTopDialog(s);
    }

    @Override
    public void hideAllTopDialog() {
        baseViewUtils.hideAllTopDialog();
    }

    @Override
    public void showErrorDialog(String s) {
        baseViewUtils.showErrorDialog(s);
    }

    @Override
    public String getString(int res) {
       return baseViewUtils.getString(res);
    }
}
