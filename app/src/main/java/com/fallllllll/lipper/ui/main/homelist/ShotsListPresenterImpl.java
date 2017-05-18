package com.fallllllll.lipper.ui.main.homelist;

import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.presenter.BaseListPresenter;
import com.fallllllll.lipper.core.rxjava.RxBus;
import com.fallllllll.lipper.data.databean.HomeListFilterBean;
import com.fallllllll.lipper.data.databean.eventBean.ShotsListFilterEvent;
import com.fallllllll.lipper.data.databean.eventBean.ShotsMenuLayoutEvent;
import com.fallllllll.lipper.data.local.datatank.DataTank;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.utils.LogUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fallllllll on 2017/2/4.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ShotsListPresenterImpl extends BaseListPresenter implements ShotsListContract.ShotsListPresenter {

    private DribbbleModel model;
    private ShotsListContract.ShotsListView shotsListView;
    private String currentLayoutType;
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
        initRxBus();

    }

    public void initRxBus() {
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
                    DataTank.put(AppConstants.DATA_TANK_HOME_FILTER_KEY, new HomeListFilterBean(TIME, TYPE, SORT))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(aBoolean -> {
                            }, throwable -> {
                            });
                }, throwable -> subscribeListFilterEvent()));
    }

    private void subscribeLayoutEvent() {
        mCompositeDisposable.add(RxBus.get().toFlowable(ShotsMenuLayoutEvent.class)
                .subscribe(shotsMenuLayoutEvent -> {
                    setListLayout(shotsMenuLayoutEvent);
                    DataTank.put(AppConstants.SHOTS_HOME_LAYOUT_KEY, shotsMenuLayoutEvent)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(aBoolean -> {
                            }, throwable -> {
                            });
                }, throwable -> subscribeLayoutEvent()));
    }

    public void setListLayout(ShotsMenuLayoutEvent shotsMenuLayoutEvent) {
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
    }


    private void getLayout() {
        if (currentLayoutType == null) {
            mCompositeDisposable.add(DataTank.get(AppConstants.SHOTS_HOME_LAYOUT_KEY, ShotsMenuLayoutEvent.class)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(shotsMenuLayoutEvent -> {
                        currentLayoutType = shotsMenuLayoutEvent.getShotLayoutType();
                        shotsListView.changeRecyclerViewLayout(shotsMenuLayoutEvent.getShotLayoutType());
                        getData();
                    }, throwable -> {
                        currentLayoutType = AppConstants.SHOTS_LAYOUT_LARGE;
                        getData();
                    }));


        } else {
            getData();
        }

    }

    private void getData() {
        disposeRefresh();
        shotsListView.setErrorViewVisible(false);
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
                        getLayout();
                    }, throwable -> {
                        TIME = AppConstants.NOW;
                        SORT = AppConstants.POPULARITY;
                        TYPE = AppConstants.SHOTS;
                        getLayout();
                    }));
        } else {
            getLayout();
        }
    }

    @Override
    public void loadNextPageData(final int page) {
        disposeLoadNext();
        loadNextDisposable = model.getShot(TYPE, TIME, SORT, page + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loadNextPageFinish, throwable -> onLoadNextError());

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
