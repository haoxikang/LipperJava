package com.fallllllll.lipper.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.core.fragment.BaseFragment;
import com.fallllllll.lipper.databinding.FragmentShotsBinding;
import com.fallllllll.lipper.utils.UIUtils;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public class ShotsFragment extends BaseFragment {
private FragmentShotsBinding binding;
    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void inject() {

    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentShotsBinding.inflate(inflater,container,false);
        binding.shotsAppbar.setPadding(0, UIUtils.getStatusBarHeight(getActivity()),0,0);
        return binding.getRoot();
    }

    @Override
    public void initListeners() {

    }
}
