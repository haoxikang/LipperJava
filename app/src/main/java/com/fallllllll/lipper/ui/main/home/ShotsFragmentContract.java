package com.fallllllll.lipper.ui.main.home;

import com.fallllllll.lipper.core.presenter.BasePresenter;
import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.data.databean.HomeListFilterBean;

/**
 * Created by Administrator on 2017/5/11/011.
 */

public class ShotsFragmentContract {

    interface ShotsFragmentView {

        void showBottomSheet(HomeListFilterBean homeListFilterBean);
    }

    interface ShotsFragmentPresenter extends Contract.Presenter{
        void showBottomSheet();
    }
}
