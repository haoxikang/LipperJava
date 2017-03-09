package com.example.dribbble.login;

import android.util.Log;

import com.example.dribbble.core.presenter.BasePresenter;
import com.example.dribbble.data.network.model.DribbbleModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qqq34 on 2017/3/8.
 */

public class LoginPresenter extends BasePresenter{

    private DribbbleModel mDribbbleModel;
    private LoginView mLoginView;

    public LoginPresenter(DribbbleModel dribbbleModel, LoginView loginView) {
        mDribbbleModel = dribbbleModel;
        mLoginView = loginView;
    }

    @Override
    public void onPresenterCreate() {
        Disposable disposable =mDribbbleModel.getShot("animated","week","a83a642ca0a4a1017aa9645ca344b8ea94f31aa838a5e22ea1ac232b3a4d4a9a")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( testList-> {
                    mLoginView.onDataFetch(testList.get(0));

                },throwable -> {
                });
        mCompositeDisposable.add(disposable);

    }

}
