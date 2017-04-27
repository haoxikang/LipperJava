package com.fallllllll.lipper.ui.main.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fall.generalrecyclerviewfragment.GeneralContract;
import com.fallllllll.lipper.core.fragment.BaseFragment;
import com.fallllllll.lipper.core.fragment.BaseListFragment;

/**
 * Created by Administrator on 2017/4/27/027.
 */

public class ShotListFragment extends BaseListFragment{
    private TestPresenter testPresenter;
    private TestAdapter testAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @NonNull
    @Override
    protected GeneralContract.Presenter getPresenter() {
        if (testPresenter == null) {
            testPresenter = new TestPresenter();
        }
        return testPresenter;
    }

    @NonNull
    @Override
    protected RecyclerView.Adapter getAdapter() {
        if (testAdapter == null) {
            testAdapter = new TestAdapter();
        }
        return testAdapter;
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {

        return  new LinearLayoutManager(getContext());
    }
}
