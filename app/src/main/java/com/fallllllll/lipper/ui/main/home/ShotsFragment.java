package com.fallllllll.lipper.ui.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.fragment.BaseFragment;
import com.fallllllll.lipper.databinding.FragmentShotsBinding;
import com.fallllllll.lipper.ui.main.SearchFragment;
import com.fallllllll.lipper.ui.view.adapter.ViewPagerAdapter;
import com.fallllllll.lipper.ui.view.widget.GeneralRecyclerViewFragment.GeneralRecyclerViewFragment;
import com.lapism.searchview.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/4/20/020.
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

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        fragmentList = new ArrayList<>();
        title_lsit = Arrays.asList(getResources().getStringArray(R.array.sort));
    }

    @Override
    protected void inject() {

    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentShotsBinding.inflate(inflater, container, false);
        tabLayout = binding.shotsTablayout;
        viewPager = binding.shotsViewpager;
        toolbar = binding.shtosToolar;
        searchView = binding.searchView;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        TestAdapter textAdapter = new TestAdapter();
        GeneralRecyclerViewFragment generalRecyclerViewFragment = new GeneralRecyclerViewFragment();
        generalRecyclerViewFragment.initialize(new TestPresenter(), textAdapter, new LinearLayoutManager(getContext()));


        fragmentList.add(generalRecyclerViewFragment);
        fragmentList.add(new SearchFragment());
        fragmentList.add(new SearchFragment());
        fragmentList.add(new SearchFragment());

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
                    searchView.open(true,item);
                    break;
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
