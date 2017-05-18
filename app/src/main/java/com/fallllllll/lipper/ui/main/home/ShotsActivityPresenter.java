package com.fallllllll.lipper.ui.main.home;

import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.presenter.BasePresenter;
import com.fallllllll.lipper.data.databean.HomeListFilterBean;
import com.fallllllll.lipper.data.local.datatank.DataTank;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fallllllll on 2017/5/11/011.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ShotsActivityPresenter extends BasePresenter implements ShotsActivityContract.ShotsActivityPresenter {
    private ShotsActivityContract.ShotsActivityView shotsActivityView;

    public ShotsActivityPresenter(ShotsActivityContract.ShotsActivityView shotsActivityView) {
        this.shotsActivityView = shotsActivityView;
    }

    @Override
    public void onPresenterCreate() {

    }

    @Override
    public void showBottomSheet() {

        mCompositeDisposable.add(DataTank.get(AppConstants.DATA_TANK_HOME_FILTER_KEY,HomeListFilterBean.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(homeListFilterBean -> {
                    if (homeListFilterBean != null) {
                        shotsActivityView.showBottomSheet(homeListFilterBean);
                    } else {
                        showDefaultBottomSheet(null);
                    }
                }, throwable -> showDefaultBottomSheet(null)));
    }

    private void showDefaultBottomSheet(HomeListFilterBean homeListFilterBean) {
        if (homeListFilterBean == null) {
            shotsActivityView.showBottomSheet(new HomeListFilterBean(AppConstants.NOW, AppConstants.SHOTS, AppConstants.POPULARITY));
        } else {
            shotsActivityView.showBottomSheet(homeListFilterBean);
        }

    }
}
