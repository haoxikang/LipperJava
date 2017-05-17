package com.fallllllll.lipper.core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.fallllllll.lipper.core.presenter.PresenterLifecycleHelper;

/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
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
