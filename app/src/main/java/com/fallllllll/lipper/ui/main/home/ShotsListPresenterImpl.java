package com.fallllllll.lipper.ui.main.home;

import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.presenter.BaseListPresenter;
import com.fallllllll.lipper.data.databean.eventBean.ShotsMenuLayoutEvent;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.utils.LogUtils;
import com.fallllllll.lipper.core.rxjava.RxBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qqq34 on 2017/2/4.
 */

public class ShotsListPresenterImpl extends BaseListPresenter implements ShotsListContract.ShotsListPresenter {

    private DribbbleModel model;
    private ShotsListContract.ShotsListView shotsListView;

    public ShotsListPresenterImpl(DribbbleModel model, ShotsListContract.ShotsListView shotsListView) {
        this.model = model;
        this.shotsListView = shotsListView;
    }

    @Override
    public void onPresenterCreate() {
        super.onPresenterCreate();
        mCompositeDisposable.add(RxBus.get().toFlowable(ShotsMenuLayoutEvent.class)
                .subscribe(shotsMenuLayoutEvent -> {
                    shotsListView.setRecyclerViewLayout();
                }));
    }

    @Override
    public void refreshData() {
        mCompositeDisposable.add(model.getShot(AppConstants.SHOTS, AppConstants.NOW, AppConstants.POPULARITY, "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shotBeans -> {
                    refreshFinish(shotBeans);
                }, throwable -> {
                    LogUtils.d(throwable.getMessage());
                    onRefreshError();
                }));
    }

    @Override
    public void loadNextPageData(final int page) {
        mCompositeDisposable.add(model.getShot(AppConstants.SHOTS, AppConstants.NOW, AppConstants.POPULARITY, page + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shotBeans -> {
                    loadNextPageFinish(shotBeans);
                }, throwable -> {
                    onLoadNextError();
                }));

    }
}
