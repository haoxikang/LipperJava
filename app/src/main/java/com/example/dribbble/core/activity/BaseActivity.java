package com.example.dribbble.core.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.dribbble.core.BaseView;
import com.example.dribbble.core.presenter.Presenter;
import com.example.dribbble.core.presenter.PresenterLifecycleHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqq34 on 2017/3/8.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private PresenterLifecycleHelper mPresenterLifecycleHelper;
    protected List<Presenter> mPresenterList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
        initListeners();
        mPresenterLifecycleHelper = new PresenterLifecycleHelper(mPresenterList);
        mPresenterLifecycleHelper.attachl();
        mPresenterLifecycleHelper.onPresenterCreate();


    }

    @Override
    protected void onDestroy() {
        mPresenterLifecycleHelper.destroyPresenter();
        super.onDestroy();
    }

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    protected  abstract void initListeners();

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
