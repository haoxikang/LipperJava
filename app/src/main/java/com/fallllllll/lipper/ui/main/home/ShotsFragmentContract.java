package com.fallllllll.lipper.ui.main.home;

import com.fallllllll.lipper.core.presenter.BasePresenter;
import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.data.databean.HomeListFilterBean;

/**
 * Created by fallllllll on 2017/5/11/011.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ShotsFragmentContract {

    interface ShotsFragmentView {

        void showBottomSheet(HomeListFilterBean homeListFilterBean);
    }

    interface ShotsFragmentPresenter extends Contract.Presenter{
        void showBottomSheet();
    }
}
