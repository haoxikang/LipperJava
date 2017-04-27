package com.fallllllll.lipper.core.presenter;

import com.fall.generalrecyclerviewfragment.GeneralPresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Administrator on 2017/4/27/027.
 */

public abstract class BaseListPresenter extends GeneralPresenter implements Contract.Presenter{
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
