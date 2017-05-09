package com.fallllllll.lipper.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.fallllllll.lipper.R;
import com.tapadoo.alerter.Alert;
import com.tapadoo.alerter.Alerter;

/**
 * Created by fallllllll on 2017/5/3/003.
 */

public class BaseViewUtils {
    private Context mContext;
    private Alert alert;
    public BaseViewUtils(Context context) {
        this.mContext = context;
    }

    public void showToast(String s) {
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
    }


    public void showTopDialog(String s) {
        hideAllTopDialog();
        alert = Alerter.create((Activity)mContext)
                .setText(s)
                .setDuration(Integer.MAX_VALUE)
                .setBackgroundColor(R.color.primary)
                .setOnClickListener(v -> {

                })
                .show();
    }


    public void hideAllTopDialog() {
        if (alert!=null&&alert.isShown()){
            alert.hide();
        }
    }


    public void showErrorDialog(String s) {
        hideAllTopDialog();
        alert = Alerter.create((Activity)mContext)
                .setText(s)
                .setBackgroundColor(R.color.accent)
                .setDuration(2000)
                .show();
    }


    public String getString(int res) {
        return mContext.getString(res);
    }
}
