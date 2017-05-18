package com.fallllllll.lipper.ui.main.homelist;

import com.fallllllll.lipper.core.presenter.BasePresenter;
import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.data.databean.eventBean.ShotsMenuLayoutEvent;

/**
 * Created by fallllllll on 2017/4/28/028.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ShotsListContract {
    interface ShotsListView extends Contract.BaseView{

        void changeRecyclerViewLayout(String LayoutType);

        void changeItemViewLayout(String layoutType);

        void setErrorViewVisible(boolean isShow);

    }
    interface ShotsListPresenter extends Contract.Presenter{

    }
}
