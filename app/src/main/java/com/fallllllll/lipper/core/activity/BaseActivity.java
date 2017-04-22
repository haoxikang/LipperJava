package com.fallllllll.lipper.core.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.core.presenter.PresenterLifecycleHelper;
import com.fallllllll.lipper.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 康颢曦 on 2017/3/8.
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

    protected abstract void initListeners();

    protected abstract void inject();

    protected void setDarkStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

}
