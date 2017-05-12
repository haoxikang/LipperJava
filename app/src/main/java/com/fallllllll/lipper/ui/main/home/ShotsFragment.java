package com.fallllllll.lipper.ui.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.fragment.BaseFragment;
import com.fallllllll.lipper.data.databean.HomeListFilterBean;
import com.fallllllll.lipper.databinding.FragmentShotsBinding;
import com.fallllllll.lipper.ui.main.homelist.ShotsListFragment;
import com.lapism.searchview.SearchView;

/**
 * Created by fallllllll on 2017/4/20/020.
 */

public class ShotsFragment extends BaseFragment implements ShotsFragmentContract.ShotsFragmentView {
    public FragmentShotsBinding binding;
    private Toolbar toolbar;
    private SearchView searchView;
    public HomeItemLayoutPopWindow popWindow;
    private ShotsListFragment shotsListFragment;
    private HomeBottomSheetFragment homeBottomSheetFragment;
    private ShotsFragmentContract.ShotsFragmentPresenter presenter;


    public void setPresenter(ShotsFragmentContract.ShotsFragmentPresenter presenter){
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentShotsBinding.inflate(inflater, container, false);
        toolbar = binding.shtosToolar;
        searchView = binding.searchView;
        popWindow = new HomeItemLayoutPopWindow(getActivity());
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        showFragment();
        if (presenter==null){
            presenter = new ShotsFragmentPresenter(this);
        }

        presenterLifecycleHelper.addPresenter(presenter);
        return binding.getRoot();
    }


    private void showFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (shotsListFragment == null) {
            shotsListFragment = new ShotsListFragment();
        }
        fragmentTransaction.replace(R.id.fragment_container, shotsListFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void initListeners() {
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.shots_menu_search: {
                    searchView.open(true, item);
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
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shots_menu_search: {
                searchView.open(true, item);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.shots_menu, menu);
    }

    @Override
    public void showBottomSheet(HomeListFilterBean homeListFilterBean) {
        if (homeBottomSheetFragment == null) {
            homeBottomSheetFragment = HomeBottomSheetFragment.newInstance(homeListFilterBean.getTime(), homeListFilterBean.getType(), homeListFilterBean.getSort());
        } else {
            homeBottomSheetFragment.updateCheckStatus(homeListFilterBean.getTime(), homeListFilterBean.getType(), homeListFilterBean.getSort());
        }
        homeBottomSheetFragment.show(getChildFragmentManager(), "bottomSheet");
    }
}
