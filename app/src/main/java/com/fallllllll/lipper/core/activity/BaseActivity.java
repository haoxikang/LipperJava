package com.fallllllll.lipper.core.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fallllllll.lipper.core.presenter.PresenterLifecycleHelper;

/**
 * Created by fallllllll on 2017/3/8.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected PresenterLifecycleHelper presenterLifecycleHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterLifecycleHelper = new PresenterLifecycleHelper();
        initViewAndData();
        initListeners();
    }

protected abstract  void  initViewAndData();
    protected abstract void initListeners();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterLifecycleHelper.destroyPresenter();
    }

    protected void setDarkStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

}
