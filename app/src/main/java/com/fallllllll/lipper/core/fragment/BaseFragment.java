package com.fallllllll.lipper.core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.core.presenter.PresenterLifecycleHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public abstract class BaseFragment extends Fragment {
    protected PresenterLifecycleHelper presenterLifecycleHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterLifecycleHelper = new PresenterLifecycleHelper();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
    }

    public abstract void initListeners();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterLifecycleHelper.destroyPresenter();
    }
}
