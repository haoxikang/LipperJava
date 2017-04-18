package com.example.dribbble.core.presenter;

import android.support.annotation.StringRes;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public interface Contract {
    interface BaseView {
        void showToast(String s);
        void showTopDialog(String s);
        void hideAllTopDialog();
        void showErrorDialog(String s);
        String getString(@StringRes int res);

    }

    interface Presenter {
        void attach();

        void detach();

        void onPresenterCreate();
    }
}
