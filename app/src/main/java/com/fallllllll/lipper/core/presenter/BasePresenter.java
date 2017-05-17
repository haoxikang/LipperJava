package com.fallllllll.lipper.core.presenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
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
