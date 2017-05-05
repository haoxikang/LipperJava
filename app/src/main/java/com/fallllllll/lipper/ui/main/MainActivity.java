package com.fallllllll.lipper.ui.main;

import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.activity.BaseActivity;
import com.fallllllll.lipper.databinding.ActivityMainBinding;
import com.fallllllll.lipper.ui.main.home.ShotsFragment;
import com.fallllllll.lipper.ui.view.adapter.ViewPagerAdapter;
import com.fallllllll.lipper.utils.MDStatusBarCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private List<Fragment> fragments;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private MenuItem menuItem;
    private List<String> bottomTabName;


    @Override
    protected void initViewAndData() {
        bottomTabName = Arrays.asList(getResources().getStringArray(R.array.home_page));
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MDStatusBarCompat.setOrdinaryToolBar(this);


        viewPager = binding.viewPager;
        bottomNavigationView = binding.navigation;
        fragments = new ArrayList<>();
        fragments.add(new ShotsFragment());
        fragments.add(new SearchFragment());
        fragments.add(new UserFragment());
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.setFragmentList(fragments, bottomTabName);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(3);


    }




    @Override
    protected void initListeners() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_shots:
                    viewPager.setCurrentItem(0, true);
                    return true;
                case R.id.navigation_search:
                    viewPager.setCurrentItem(1, true);
                    return true;
                case R.id.navigation_person:
                    viewPager.setCurrentItem(2, true);
                    return true;
            }
            return false;
        });
    }

}
