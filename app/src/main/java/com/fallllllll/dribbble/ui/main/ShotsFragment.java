package com.fallllllll.dribbble.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fallllllll.dribbble.R;
import com.fallllllll.dribbble.core.fragment.BaseFragment;
import com.fallllllll.dribbble.databinding.FragmentShotsBinding;

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

        return binding.getRoot();
    }

    @Override
    public void initListeners() {

    }
}
