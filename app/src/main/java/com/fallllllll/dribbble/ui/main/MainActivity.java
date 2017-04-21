package com.fallllllll.dribbble.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.transition.Explode;
import android.view.MenuItem;

import com.fallllllll.dribbble.R;
import com.fallllllll.dribbble.core.activity.BaseActivity;
import com.fallllllll.dribbble.databinding.ActivityMainBinding;
import com.fallllllll.dribbble.utils.MDStatusBarCompat;
import com.fallllllll.dribbble.view.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private List<Fragment> fragments;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private MenuItem menuItem;

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        getWindow().setEnterTransition(new Explode().setDuration(1000));
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            MDStatusBarCompat.setImageTransparent(this);
            setDarkStatusBar();
        }else {
            MDStatusBarCompat.setImageTranslucent(this);
        }

        viewPager = binding.viewPager;
        bottomNavigationView = binding.navigation;
        fragments = new ArrayList<>();
        fragments.add(new ShotsFragment());
        fragments.add(new SearchFragment());
        fragments.add(new UserFragment());
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.setFragmentList(fragments);
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

    @Override
    protected void inject() {

    }
}
