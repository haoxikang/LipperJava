package com.example.dribbble.core.presenter;

/**
 * Created by qqq34 on 2017/3/8.
 */

public interface Contract {
     interface BaseView {
        void showToast(String s);
    }
     interface Presenter {
        void attach();
        void detach();
        void onPresenterCreate();
    }
}
