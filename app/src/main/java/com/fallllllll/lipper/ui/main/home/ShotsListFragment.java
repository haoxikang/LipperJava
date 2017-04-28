package com.fallllllll.lipper.ui.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fall.generalrecyclerviewfragment.GeneralContract;
import com.fallllllll.lipper.DribbbleApplication;
import com.fallllllll.lipper.core.fragment.BaseListFragment;

import javax.inject.Inject;

/**
 * Created by fallllllll on 2017/4/27/027.
 */

public class ShotsListFragment extends BaseListFragment {

    private ShotsListModule shotsListModule;
    private ShotsListViewModel shotsListViewModel;

    public void setShotsListModule(ShotsListModule shotsListModule) {
        this.shotsListModule = shotsListModule;
    }


    @Inject
    ShotsListContract.ShotsListPresenter shotsListPresenter;

    private ShotsListAdapter shotsListAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shotsListViewModel = new ShotsListViewModel(getContext());
        if (shotsListModule == null) {
            shotsListModule = new ShotsListModule(shotsListViewModel);
        }
        DaggerShotsListComponent
                .builder()
                .appComponent(DribbbleApplication.getInstance().getAppComponent())
                .shotsListModule(shotsListModule)
                .build()
                .inject(this);
        presenterLifecycleHelper.addPresenter(shotsListPresenter);

    }

    @NonNull
    @Override
    protected GeneralContract.Presenter getPresenter() {
        return (GeneralContract.Presenter) shotsListPresenter;
    }

    @NonNull
    @Override
    protected RecyclerView.Adapter getAdapter() {
        if (shotsListAdapter == null) {
            shotsListAdapter = new ShotsListAdapter();
        }
        return shotsListAdapter;
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {

        return new LinearLayoutManager(getContext());
    }
}
