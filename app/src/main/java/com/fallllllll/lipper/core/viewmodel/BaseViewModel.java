package com.fallllllll.lipper.core.viewmodel;

import android.content.Context;

import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.utils.BaseViewUtils;

/**
 * Created by fallllllll on 2017/3/10.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class BaseViewModel implements Contract.BaseView {
    protected Context mContext;
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
