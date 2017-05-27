package com.fallllllll.lipper.ui.main.home;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.activity.BaseActivity;
import com.fallllllll.lipper.data.databean.HomeListFilterBean;
import com.fallllllll.lipper.ui.main.homelist.ShotsListFragment;
import com.fallllllll.lipper.ui.search.SearchActivity;
import com.fallllllll.lipper.utils.MDStatusBarCompat;
import com.fallllllll.lipper.utils.UIUtils;

/**
 * Created by fallllllll on 2017/4/20/020.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ShotsActivity extends BaseActivity implements ShotsActivityContract.ShotsActivityView {
    private Toolbar toolbar;
    public HomeItemLayoutPopWindow popWindow;
    private ShotsListFragment shotsListFragment;
    private HomeBottomSheetFragment homeBottomSheetFragment;
    private ShotsActivityContract.ShotsActivityPresenter presenter;


    public void setPresenter(ShotsActivityContract.ShotsActivityPresenter presenter) {
        this.presenter = presenter;
    }


    private void showFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (shotsListFragment == null) {
            shotsListFragment = new ShotsListFragment();
        }
        fragmentTransaction.replace(R.id.fragment_container, shotsListFragment);
        fragmentTransaction.commit();

    }

    @Override
    protected void initViewAndData() {
        setContentView(R.layout.activity_shots);
        toolbar = (Toolbar) findViewById(R.id.shots_toolbar);
        toolbar.setPadding(0, UIUtils.getStatusBarHeight(this), 0, 0);
        MDStatusBarCompat.setImageTranslucent(this);
        popWindow = new HomeItemLayoutPopWindow(this);
        setSupportActionBar(toolbar);
        showFragment();
        if (presenter == null) {
            presenter = new ShotsActivityPresenter(this);
        }

        presenterLifecycleHelper.addPresenter(presenter);
    }

    @Override
    public void initListeners() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shots_menu_search: {
                View searchMenuView = toolbar.findViewById(R.id.shots_menu_search);
                Bundle options = ActivityOptions.makeSceneTransitionAnimation(this, searchMenuView,
                        getString(R.string.transition_search_back)).toBundle();
                startActivity(new Intent(this, SearchActivity.class), options);
                break;
            }
            case R.id.shots_menu_layout: {
                popWindow.showPopupWindow(toolbar);
                break;
            }
            case R.id.filter_list: {
                presenter.showBottomSheet();
                break;
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shots_menu, menu);
        return true;
    }


    @Override
    public void showBottomSheet(HomeListFilterBean homeListFilterBean) {
        if (homeBottomSheetFragment == null) {
            homeBottomSheetFragment = HomeBottomSheetFragment.newInstance(homeListFilterBean.getTime(), homeListFilterBean.getType(), homeListFilterBean.getSort());
        }
        if (!homeBottomSheetFragment.isAdded()){
            homeBottomSheetFragment.show(getSupportFragmentManager(), "bottomSheet");
        }

    }
}
