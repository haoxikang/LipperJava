package com.example.dribbble.core.presenter;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public interface Contract {
    interface BaseView {
        void showToast(String s);
        void showTopDialog(String s);
        void hideAllTopDialog();
        void showErrorDialog(String s);

    }

    interface Presenter {
        void attach();

        void detach();

        void onPresenterCreate();
    }
}
