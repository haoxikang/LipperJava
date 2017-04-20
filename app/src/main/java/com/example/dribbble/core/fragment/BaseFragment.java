package com.example.dribbble.core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dribbble.core.presenter.Contract;
import com.example.dribbble.core.presenter.PresenterLifecycleHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public abstract class BaseFragment extends Fragment  {
    private PresenterLifecycleHelper mPresenterLifecycleHelper;
    protected List<Contract.Presenter> mPresenterList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(savedInstanceState);
        inject();
        initData(savedInstanceState);
        initListeners();
        mPresenterLifecycleHelper = new PresenterLifecycleHelper(mPresenterList);
        mPresenterLifecycleHelper.attach();
        mPresenterLifecycleHelper.onPresenterCreate();
        return view;
    }

    protected abstract void initData(@Nullable Bundle savedInstanceState);

    protected abstract void inject();

    protected abstract View initView(@Nullable Bundle savedInstanceState);

    public abstract void initListeners();

}
