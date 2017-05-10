package com.fallllllll.lipper.ui.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.databinding.FragmentHomeBottomSheetBinding;

/**
 * Created by Administrator on 2017/5/10/010.
 */

public class HomeBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentHomeBottomSheetBinding bottomSheetBinding;
    private HomeBottomSheetFragmentViewModel viewModel;
    private AppCompatRadioButton radioButton;
    private static final String TIME_KEY = "HomeBottomSheetFragment.time";
    private static final String TYPE_KEY = "HomeBottomSheetFragment.type";
    private static final String SORT_KEY = "HomeBottomSheetFragment.sort";

    private  String time;
    private  String type;
    private String sort;

    public void updateCheckStatus(String time, String type, String sort) {
            this.time=time;
            this.type = type;
            this.sort = sort;
    }

    public static HomeBottomSheetFragment newInstance(String time, String type, String sort) {

        Bundle args = new Bundle();
        args.putString(TIME_KEY, time);
        args.putString(TYPE_KEY, type);
        args.putString(SORT_KEY, sort);
        HomeBottomSheetFragment fragment = new HomeBottomSheetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.time=getArguments().getString(TIME_KEY);
        this.type = getArguments().getString(TYPE_KEY);
        this.sort = getArguments().getString(SORT_KEY);
        bottomSheetBinding = FragmentHomeBottomSheetBinding.inflate(inflater, container, false);
        viewModel = new HomeBottomSheetFragmentViewModel(getContext(), time, sort,type);
        bottomSheetBinding.setViewModel(viewModel);
        radioButton = bottomSheetBinding.test;
        radioButton.setChecked(true);
        initListener();
        return bottomSheetBinding.getRoot();
    }

    private void initListener() {
        bottomSheetBinding.applyText.setOnClickListener(v -> {
            this.dismiss();
        });
    }
}
