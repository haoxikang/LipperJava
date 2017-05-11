package com.fallllllll.lipper.ui.main.homelist;

import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.presenter.BaseListPresenter;
import com.fallllllll.lipper.data.databean.HomeListFilterBean;
import com.fallllllll.lipper.data.databean.eventBean.ShotsListFilterEvent;
import com.fallllllll.lipper.data.databean.eventBean.ShotsMenuLayoutEvent;
import com.fallllllll.lipper.data.local.datatank.DataTank;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.utils.LogUtils;
import com.fallllllll.lipper.core.rxjava.RxBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qqq34 on 2017/2/4.
 */

public class ShotsListPresenterImpl extends BaseListPresenter implements ShotsListContract.ShotsListPresenter {

    private DribbbleModel model;
    private ShotsListContract.ShotsListView shotsListView;
    private String currentLayoutType = AppConstants.SHOTS_LAYOUT_LARGE;
    private String TIME = "";
    private String SORT = "";
    private String TYPE = "";
    private Disposable refreshDisposable;
    private Disposable loadNextDisposable;
    private boolean canShowError = true;


    public ShotsListPresenterImpl(DribbbleModel model, ShotsListContract.ShotsListView shotsListView) {
        this.model = model;
        this.shotsListView = shotsListView;
    }

    @Override
    public void onPresenterCreate() {
        super.onPresenterCreate();
        subscribeLayoutEvent();
        subscribeListFilterEvent();

    }

    private void subscribeListFilterEvent() {
        mCompositeDisposable.add(RxBus.get().toFlowable(ShotsListFilterEvent.class)
                .subscribe(shotsListFilterEvent -> {
                    stopLoading();
                    TIME = shotsListFilterEvent.getTime();
                    SORT = shotsListFilterEvent.getSort();
                    TYPE = shotsListFilterEvent.getType();
                    checkAndRefreshData();
                    DataTank.put(AppConstants.DATA_TANK_HOME_FILTER_KEY, new HomeListFilterBean(TIME, TYPE, SORT)).subscribe(aBoolean -> {
                        LogUtils.d(aBoolean + "");
                    }, throwable -> {
                        LogUtils.d(throwable.getMessage());
                    });
                }, throwable -> {
                    LogUtils.d(throwable.getMessage());
                    subscribeListFilterEvent();
                }));
    }

    private void subscribeLayoutEvent() {
        mCompositeDisposable.add(RxBus.get().toFlowable(ShotsMenuLayoutEvent.class)
                .subscribe(shotsMenuLayoutEvent -> {
                    if (!currentLayoutType.equals(shotsMenuLayoutEvent.getShotLayoutType())) {
                        if ((currentLayoutType.equals(AppConstants.SHOTS_LAYOUT_SMALL) || currentLayoutType.equals(AppConstants.SHOTS_LAYOUT_ONLY_IMAGE))
                                &&
                                (shotsMenuLayoutEvent.getShotLayoutType().equals(AppConstants.SHOTS_LAYOUT_SMALL) || shotsMenuLayoutEvent.getShotLayoutType().equals(AppConstants.SHOTS_LAYOUT_ONLY_IMAGE))) {
                            shotsListView.changeItemViewLayout(shotsMenuLayoutEvent.getShotLayoutType());
                        } else {
                            shotsListView.changeRecyclerViewLayout(shotsMenuLayoutEvent.getShotLayoutType());


                        }
                        currentLayoutType = shotsMenuLayoutEvent.getShotLayoutType();
                    }
                }, throwable -> subscribeLayoutEvent()));
    }

    private void getData() {
        disposeRefresh();
        refreshDisposable = model.getShot(TYPE, TIME, SORT, "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shotBeans -> {
                    refreshFinish(shotBeans);
                    canShowError = false;
                }, throwable -> {
                    LogUtils.d(throwable.getMessage());
                    if (canShowError) {
                        onRefreshError();
                    } else {
                        onReloadError();
                    }

                });
    }

    @Override
    public void refreshData() {
        if ("".equals(TIME)) {
            mCompositeDisposable.add(DataTank.get(AppConstants.DATA_TANK_HOME_FILTER_KEY, HomeListFilterBean.class)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(homeListFilterBean -> {
                        if (homeListFilterBean != null) {
                            TIME = homeListFilterBean.getTime();
                            SORT = homeListFilterBean.getSort();
                            TYPE = homeListFilterBean.getType();
                        } else {
                            TIME = AppConstants.NOW;
                            SORT = AppConstants.POPULARITY;
                            TYPE = AppConstants.SHOTS;
                        }
                        getData();
                    }, throwable -> {
                        TIME = AppConstants.NOW;
                        SORT = AppConstants.POPULARITY;
                        TYPE = AppConstants.SHOTS;
                        getData();
                    }));
        } else {
            getData();
        }


    }

    @Override
    public void loadNextPageData(final int page) {
        disposeLoadNext();
        loadNextDisposable = model.getShot(TYPE, TIME, SORT, page + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shotBeans -> {
                    loadNextPageFinish(shotBeans);
                }, throwable -> {
                    onLoadNextError();
                });

    }

    @Override
    public void detach() {
        super.detach();
        disposeLoadNext();
        disposeRefresh();

    }

    private void disposeLoadNext() {
        if (loadNextDisposable != null && !loadNextDisposable.isDisposed()) {
            loadNextDisposable.dispose();
        }
    }

    private void disposeRefresh() {
        if (refreshDisposable != null && !refreshDisposable.isDisposed()) {
            refreshDisposable.dispose();
        }
    }
}
