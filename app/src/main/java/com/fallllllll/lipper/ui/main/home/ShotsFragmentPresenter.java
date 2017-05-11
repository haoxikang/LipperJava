package com.fallllllll.lipper.ui.main.home;

import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.presenter.BasePresenter;
import com.fallllllll.lipper.data.databean.HomeListFilterBean;
import com.fallllllll.lipper.data.local.datatank.DataTank;
import com.fallllllll.lipper.utils.LogUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/11/011.
 */

public class ShotsFragmentPresenter extends BasePresenter implements ShotsFragmentContract.ShotsFragmentPresenter {
    private ShotsFragmentContract.ShotsFragmentView shotsFragmentView;

    public ShotsFragmentPresenter(ShotsFragmentContract.ShotsFragmentView shotsFragmentView) {
        this.shotsFragmentView = shotsFragmentView;
    }

    @Override
    public void onPresenterCreate() {

    }

    @Override
    public void showBottomSheet() {
        mCompositeDisposable.add(DataTank.get(AppConstants.DATA_TANK_HOME_FILTER_KEY, HomeListFilterBean.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(homeListFilterBean -> {
                    if (homeListFilterBean != null) {
                        shotsFragmentView.showBottomSheet(homeListFilterBean);
                        LogUtils.d(homeListFilterBean.toString());
                    } else {
                        showDefaultBottomSheet();
                    }
                }, throwable -> {
                    showDefaultBottomSheet();
                }));
    }

    private void showDefaultBottomSheet() {
        shotsFragmentView.showBottomSheet(new HomeListFilterBean(AppConstants.NOW, AppConstants.SHOTS, AppConstants.POPULARITY));
    }
}
