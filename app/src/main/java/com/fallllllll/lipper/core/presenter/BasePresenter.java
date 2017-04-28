package com.fallllllll.lipper.core.presenter;

import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ApiException;
import com.fallllllll.lipper.core.rxjava.exceptionalhandling.ERROR;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by fallllllll on 2017/3/8.
 */

public abstract class BasePresenter implements Contract.Presenter{
    protected CompositeDisposable mCompositeDisposable;

    @Override
    public void attach() {
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detach() {
        mCompositeDisposable.dispose();
        mCompositeDisposable = null;
    }




}
