package com.fallllllll.lipper.ui.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.R;
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
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Toolbar toolbar;
    private List<Fragment> fragmentList;
    private List<String> title_lsit;
    private SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentList = new ArrayList<>();
        title_lsit = Arrays.asList(getResources().getStringArray(R.array.sort));
        binding = FragmentShotsBinding.inflate(inflater, container, false);
        tabLayout = binding.shotsTablayout;
        viewPager = binding.shotsViewpager;
        toolbar = binding.shtosToolar;
        searchView = binding.searchView;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        fragmentList.add(new ShotsListFragment());
        fragmentList.add(new ShotsListFragment());
        fragmentList.add(new ShotsListFragment());
        fragmentList.add(new ShotsListFragment());

        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.setFragmentList(fragmentList, title_lsit);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        return binding.getRoot();
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
                    RxBus.get().post(new ShotsMenuLayoutEvent());
                }
            }
            return true;
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.shots_menu, menu);
    }
}
