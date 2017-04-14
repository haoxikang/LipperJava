package com.example.dribbble.login;

import android.util.Log;

import com.example.dribbble.core.presenter.BasePresenter;
import com.example.dribbble.data.local.user.UserManager;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.OauthModel;
import com.example.dribbble.utils.LogUtils;
import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public class LoginPresenterImpl extends BasePresenter implements LoginContract.LoginPresenter {

    private DribbbleModel mDribbbleModel;
    private OauthModel oauthModel;
    private LoginContract.LoginView mLoginView;

    public LoginPresenterImpl(DribbbleModel dribbbleModel, OauthModel oauthModel, LoginContract.LoginView loginView) {
        mDribbbleModel = dribbbleModel;
        this.oauthModel = oauthModel;
        mLoginView = loginView;
    }

    @Override
    public void onPresenterCreate() {
        Disposable disposable = mDribbbleModel.getShot("animated", "week")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(testList -> {
                    mLoginView.onDataFetch(testList.get(0));
                }, throwable -> {
                });
        mCompositeDisposable.add(disposable);

    }

    @Override
    public void getUserData(String code) {
        mLoginView.showTopDialog("正在登录，请稍后");
        Disposable disposable = oauthModel.getToken(code)
                .subscribeOn(Schedulers.io())
//                .map(userToken -> {
//                    Log.d("map", Thread.currentThread().getName());
//                    UserManager.INSTANCE.updateToken(userToken);
//                    return userToken;
//                })
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .flatMap(userToken -> {
//                    Log.d("flatmap", Thread.currentThread().getName());
//                  return mDribbbleModel.getUserInfo();
//                })
//                .subscribeOn(Schedulers.io())
       .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userToken -> {
                    Log.d("aaaaaa", userToken.getAccess_token());
                });
        mCompositeDisposable.add(disposable);

    }

    @Override
    public void onLoginClick() {
        mLoginView.GoWebActivityForResult();
    }
}
