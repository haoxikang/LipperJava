package com.example.dribbble.core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dribbble.core.presenter.Contract;
import com.example.dribbble.core.presenter.PresenterLifecycleHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqq34 on 2017/3/8.
 */

public abstract class BaseFragment extends Fragment implements Contract.BaseView {
    private PresenterLifecycleHelper mPresenterLifecycleHelper;
    protected List<Contract.Presenter> mPresenterList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inject();
        View view = initView(savedInstanceState);
        initListeners();
        mPresenterLifecycleHelper = new PresenterLifecycleHelper(mPresenterList);
        mPresenterLifecycleHelper.attachl();
        mPresenterLifecycleHelper.onPresenterCreate();
        return view;
    }

    protected abstract void inject();

    abstract View initView(@Nullable Bundle savedInstanceState);

    abstract void initListeners();

    @Override
    public void showToast(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
