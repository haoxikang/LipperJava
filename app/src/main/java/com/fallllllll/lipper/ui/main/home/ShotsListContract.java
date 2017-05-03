package com.fallllllll.lipper.ui.main.home;

import com.fallllllll.lipper.core.presenter.BasePresenter;
import com.fallllllll.lipper.core.presenter.Contract;

/**
 * Created by Administrator on 2017/4/28/028.
 */

public class ShotsListContract {
    interface ShotsListView extends Contract.BaseView{

        void setRecyclerViewLayout();

    }
    interface ShotsListPresenter extends Contract.Presenter{

    }
}
