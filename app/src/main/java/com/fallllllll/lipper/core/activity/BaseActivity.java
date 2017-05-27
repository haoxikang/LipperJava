package com.fallllllll.lipper.core.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.core.presenter.PresenterLifecycleHelper;
import com.fallllllll.lipper.utils.BaseViewUtils;

/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
 */

public abstract class BaseActivity extends AppCompatActivity implements Contract.BaseView{
    private BaseViewUtils baseViewUtils;
    protected PresenterLifecycleHelper presenterLifecycleHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterLifecycleHelper = new PresenterLifecycleHelper();
        baseViewUtils = new BaseViewUtils(this);
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
    @Override
    public void showToast(String s) {
        baseViewUtils.showToast(s);
    }

    @Override
    public void showTopDialog(String s) {
        baseViewUtils.showTopDialog(s);
    }

    @Override
    public void hideAllTopDialog() {
        baseViewUtils.hideAllTopDialog();
    }

    @Override
    public void showErrorDialog(String s) {
        baseViewUtils.showErrorDialog(s);
    }
//    protected void setDarkStatusBar() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }
//    }

}
