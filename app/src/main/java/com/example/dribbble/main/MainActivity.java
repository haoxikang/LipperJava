package com.example.dribbble.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.transition.Explode;
import android.view.MenuItem;

import com.example.dribbble.R;
import com.example.dribbble.core.activity.BaseActivity;
import com.example.dribbble.databinding.ActivityMainBinding;
import com.example.dribbble.utils.MDStatusBarCompat;
import com.example.dribbble.view.adapter.ViewPagerAdapter;

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
        MDStatusBarCompat.setImageTranslucent(this);
        viewPager = binding.viewPager;
        bottomNavigationView = binding.navigation;
        fragments = new ArrayList<>();
        fragments.add(new ShotsFragment());
        fragments.add(new ShotsFragment());
        fragments.add(new ShotsFragment());
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
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1, true);
                    return true;
                case R.id.navigation_notifications:
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
