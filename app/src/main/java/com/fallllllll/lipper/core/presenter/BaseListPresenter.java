package com.fallllllll.lipper.core.presenter;

import com.fall.generalrecyclerviewfragment.GeneralPresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by fallllllll on 2017/4/27/027.
 * GitHub :  https://github.com/348476129/Lipper
 */

public abstract class BaseListPresenter extends GeneralPresenter implements Contract.Presenter {
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
