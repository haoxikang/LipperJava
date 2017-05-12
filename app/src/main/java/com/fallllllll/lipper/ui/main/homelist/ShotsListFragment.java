package com.fallllllll.lipper.ui.main.homelist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fall.generalrecyclerviewfragment.GeneralContract;
import com.fallllllll.lipper.DribbbleApplication;
import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.fragment.BaseListFragment;
import com.fallllllll.lipper.data.databean.eventBean.ShotsMenuLayoutEvent;

import javax.inject.Inject;

/**
 * Created by fallllllll on 2017/4/27/027.
 */

public class ShotsListFragment extends BaseListFragment implements ShotsListContract.ShotsListView {

    private ShotsListModule shotsListModule;
    private ShotsListItemViewModel shotsListItemViewModel;

    public void setShotsListModule(ShotsListModule shotsListModule) {
        this.shotsListModule = shotsListModule;
    }


    @Inject
    ShotsListContract.ShotsListPresenter shotsListPresenter;

    private ShotsListAdapter shotsListAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (shotsListModule == null) {
            shotsListModule = new ShotsListModule(this);
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
            shotsListItemViewModel = new ShotsListItemViewModel(ShotsListItemViewModel.LINEAR_LAYOUT);
            shotsListAdapter = new ShotsListAdapter(shotsListItemViewModel);
        }
        return shotsListAdapter;
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {

        return new GridLayoutManager(getContext(), 1);
    }


    @Override
    public void changeRecyclerViewLayout(String layoutType) {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (layoutType.equals(AppConstants.SHOTS_LAYOUT_LARGE)) {
            shotsListItemViewModel.setLayout(ShotsListItemViewModel.LINEAR_LAYOUT);
            gridLayoutManager.setSpanCount(1);
        } else if (layoutType.equals(AppConstants.SHOTS_LAYOUT_ONLY_IMAGE)) {
            shotsListItemViewModel.setLayout(ShotsListItemViewModel.ONLY_IMAGE_LAYOUT);
            gridLayoutManager.setSpanCount(2);
        } else if (layoutType.equals(AppConstants.SHOTS_LAYOUT_SMALL)) {
            shotsListItemViewModel.setLayout(ShotsListItemViewModel.GRID_LAYOUT);
            gridLayoutManager.setSpanCount(2);
        }
        getAdapter().notifyItemRangeChanged(0, getAdapter().getItemCount());
    }

    @Override
    public void changeItemViewLayout(String layoutType) {
        if (layoutType.equals(AppConstants.SHOTS_LAYOUT_ONLY_IMAGE)) {
            shotsListItemViewModel.setLayout(ShotsListItemViewModel.ONLY_IMAGE_LAYOUT);
        }
        if (layoutType.equals(AppConstants.SHOTS_LAYOUT_SMALL)) {
            shotsListItemViewModel.setLayout(ShotsListItemViewModel.GRID_LAYOUT);
        }
    }



}
