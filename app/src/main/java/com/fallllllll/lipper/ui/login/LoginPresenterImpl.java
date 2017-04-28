package com.fallllllll.lipper.ui.login;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.presenter.BasePresenter;
import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ApiException;
import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ConvertToApiException;
import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ERROR;
import com.fallllllll.lipper.data.local.user.UserManager;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.network.model.OauthModel;
import com.fallllllll.lipper.data.network.model.impl.DribbbleModelImpl;
import com.fallllllll.lipper.utils.LipperHttpErrorUtils;
import com.fallllllll.lipper.utils.LogUtils;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.fallllllll.lipper.core.constants.TimeConstants.ACTIVITY_TRANSITIONS_TIME;

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

    private void finishActivity() {

        mCompositeDisposable.add(Flowable.timer(ACTIVITY_TRANSITIONS_TIME, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {

                }, throwable -> {
                    mLoginView.finishActivity();

                }, () -> {
                    mLoginView.finishActivity();

                }));
    }

    @Override
    public void onPresenterCreate() {
        if (UserManager.INSTANCE.isLogin()) {
            updateUserData();
        }

    }

    private void updateUserData() {
        mLoginView.setButtonEnable(false);
        mLoginView.showTopDialog(mLoginView.getString(R.string.under_login));
        Disposable disposable = DribbbleModelImpl.getInstance().getUserInfo()
                .onErrorResumeNext(new ConvertToApiException<>())
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lipperUser -> {
                    UserManager.INSTANCE.updateUser(lipperUser);
                    mLoginView.hideAllTopDialog();
                    mLoginView.goMainActivity();
                    finishActivity();
                }, throwable -> {
                    LogUtils.w(throwable.getMessage());
                    mLoginView.hideAllTopDialog();
                    mLoginView.setButtonEnable(true);
                    if (LipperHttpErrorUtils.checkToken(throwable)) {
                        mLoginView.showErrorDialog(mLoginView.getString(R.string.login_expire));
                        UserManager.INSTANCE.logOut();
                        return;
                    }
                    mLoginView.showErrorDialog(mLoginView.getString(R.string.login_failed));
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getUserData(String code) {
        mLoginView.setButtonEnable(false);
        mLoginView.showTopDialog(mLoginView.getString(R.string.under_login));
        Disposable disposable = oauthModel.getToken(code)
                .onErrorResumeNext(new ConvertToApiException<>())
                .observeOn(AndroidSchedulers.mainThread())
                .map(userToken -> {
                    LogUtils.i(new Gson().toJson(userToken));
                    UserManager.INSTANCE.updateToken(userToken);
                    return userToken;
                })
                .observeOn(Schedulers.io())
                .flatMap(userToken -> mDribbbleModel.getUserInfo())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lipperUser -> {
                    UserManager.INSTANCE.updateUser(lipperUser);
                    mLoginView.hideAllTopDialog();
                    mLoginView.goMainActivity();
                }, throwable -> {
                    mLoginView.setButtonEnable(true);
                    mLoginView.showErrorDialog(mLoginView.getString(R.string.login_failed));
                });
        mCompositeDisposable.add(disposable);

    }

    @Override
    public void onLoginClick() {
        if (UserManager.INSTANCE.isLogin()) {
            updateUserData();
        } else {
            mLoginView.goWebActivityForResult();
        }

    }
}
