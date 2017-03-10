package com.example.dribbble.core.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.dribbble.core.presenter.Contract;

/**
 * Created by qqq34 on 2017/3/10.
 */

public class BaseViewModel implements Contract.BaseView {
    private Context mContext;

    public BaseViewModel(Context context) {
        mContext = context;
    }


    @Override
    public void showToast(String s) {
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorLog(String TAG, String message) {
        Log.e(TAG, message);
    }

    @Override
    public void showDebugLog(String TAG, String message) {
        Log.d(TAG, message);
    }
}
