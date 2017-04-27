package com.fallllllll.lipper.core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fall.generalrecyclerviewfragment.GeneralRecyclerViewFragment;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.core.presenter.PresenterLifecycleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/4/27/027.
 */

public abstract class BaseListFragment extends GeneralRecyclerViewFragment {

    protected View errorView;

    protected PresenterLifecycleHelper presenterLifecycleHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterLifecycleHelper = new PresenterLifecycleHelper();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout.setColorSchemeResources(R.color.primary, R.color.accent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterLifecycleHelper.destroyPresenter();
    }


    @Override
    public void loadError() {
        errorLayout.setVisibility(View.VISIBLE);
        if (errorLayout.getChildCount() == 0) {
            errorView = LayoutInflater.from(getContext()).inflate(R.layout.view_list_error, null);
            errorLayout.addView(errorView);
            errorLayout.setOnClickListener(v -> {
                getPresenter().checkAndRefreshData();
                errorLayout.setVisibility(View.GONE);
            });
        }
    }

    @Override
    public void loadNextPageError() {
        Snackbar.make(swipeRefreshLayout, getString(R.string.failed_to_load), Snackbar.LENGTH_SHORT).show();
    }

    public void loadEmpty() {
        swipeRefreshLayout.setEnabled(false);
        errorLayout.setVisibility(View.VISIBLE);
        if (errorLayout.getChildCount() == 0) {
            errorView = LayoutInflater.from(getContext()).inflate(R.layout.view_list_error, null);
            ((ImageView) errorView.findViewById(R.id.error_image)).setImageResource(R.drawable.ic_no_data_black_48dp);
            ((TextView) errorView.findViewById(R.id.error_text)).setText(R.string.no_data);
            errorLayout.addView(errorView);
        }
    }

}
