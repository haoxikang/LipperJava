package com.example.dribbble.core.presenter;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public interface Contract {
    interface BaseView {
        void showToast(String s);

        void showErrorLog(String TAG, String message);

        void showDebugLog(String TAG, String message);

        void GoWebActivityForResult();
    }

    interface Presenter {
        void attach();

        void detach();

        void onPresenterCreate();
    }
}
