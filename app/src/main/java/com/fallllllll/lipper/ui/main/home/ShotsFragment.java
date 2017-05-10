package com.fallllllll.lipper.ui.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.fragment.BaseFragment;
import com.fallllllll.lipper.data.databean.eventBean.ShotsMenuLayoutEvent;
import com.fallllllll.lipper.databinding.FragmentShotsBinding;
import com.fallllllll.lipper.ui.main.SearchFragment;
import com.fallllllll.lipper.ui.view.adapter.ViewPagerAdapter;
import com.fallllllll.lipper.core.rxjava.RxBus;
import com.lapism.searchview.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fallllllll on 2017/4/20/020.
 */

public class ShotsFragment extends BaseFragment {
    private FragmentShotsBinding binding;
    private Toolbar toolbar;
    private SearchView searchView;
    private HomeItemLayoutPopWindow popWindow;
    private ShotsListFragment shotsListFragment;
    private HomeBottomSheetFragment homeBottomSheetFragment;

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
        return binding.getRoot();
    }


    private void showFragment() {
        FragmentManager fragmentManager = getFragmentManager();
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
                    showBottomSheet();
                    break;
                }
            }
            return true;
        });
    }


    private void showBottomSheet() {
        if (homeBottomSheetFragment == null) {
            homeBottomSheetFragment = HomeBottomSheetFragment.newInstance(AppConstants.EVER, AppConstants.POPULARITY, AppConstants.COMENTS);
        }
        homeBottomSheetFragment.show(getFragmentManager(), "bottomSheet");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.shots_menu, menu);
    }
}
