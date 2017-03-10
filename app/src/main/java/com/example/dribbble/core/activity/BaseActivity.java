package com.example.dribbble.core.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dribbble.core.presenter.Contract;
import com.example.dribbble.core.presenter.PresenterLifecycleHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqq34 on 2017/3/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private PresenterLifecycleHelper mPresenterLifecycleHelper;
    protected List<Contract.Presenter> mPresenterList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        inject();
        initView(savedInstanceState);
        initListeners();
        mPresenterLifecycleHelper = new PresenterLifecycleHelper(mPresenterList);
        mPresenterLifecycleHelper.attach();
        mPresenterLifecycleHelper.onPresenterCreate();


    }

    @Override
    protected void onDestroy() {
        mPresenterLifecycleHelper.destroyPresenter();
        super.onDestroy();
    }


    protected abstract void initData(@Nullable Bundle savedInstanceState);

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    protected  abstract void initListeners();

    protected abstract void inject();

}
