package com.fallllllll.lipper.ui.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.core.rxjava.RxBus;
import com.fallllllll.lipper.data.databean.eventBean.ShotsListFilterEvent;
import com.fallllllll.lipper.databinding.FragmentHomeBottomSheetBinding;

/**
 * Created by fallllllll on 2017/5/10/010.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class HomeBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentHomeBottomSheetBinding bottomSheetBinding;
    private static final String TIME_KEY = "HomeBottomSheetFragment.time";
    private static final String TYPE_KEY = "HomeBottomSheetFragment.type";
    private static final String SORT_KEY = "HomeBottomSheetFragment.sort";

    private String time;
    private String type;
    private String sort;

    public static HomeBottomSheetFragment newInstance(String time, String type, String sort) {

        Bundle args = new Bundle();
        args.putString(TIME_KEY, time);
        args.putString(TYPE_KEY, type);
        args.putString(SORT_KEY, sort);
        HomeBottomSheetFragment fragment = new HomeBottomSheetFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public void updateCheckStatus(String time, String type, String sort) {
        Bundle args = new Bundle();
        args.putString(TIME_KEY, time);
        args.putString(TYPE_KEY, type);
        args.putString(SORT_KEY, sort);
        setArguments(args);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        HomeBottomSheetFragmentViewModel viewModel = new HomeBottomSheetFragmentViewModel(getContext(), time, sort, type);
        this.time = getArguments().getString(TIME_KEY);
        this.type = getArguments().getString(TYPE_KEY);
        this.sort = getArguments().getString(SORT_KEY);
        bottomSheetBinding = FragmentHomeBottomSheetBinding.inflate(inflater, container, false);
        bottomSheetBinding.setViewModel(viewModel);
        initListener();
        return bottomSheetBinding.getRoot();
    }

    private void initListener() {
        bottomSheetBinding.applyText.setOnClickListener(v -> {
            RxBus.get().post(new ShotsListFilterEvent(time, sort, type));
            this.dismiss();
        });
        bottomSheetBinding.timeGroup.setOnCheckedChangeListener((group, checkedId) -> time = (String) group.findViewById(checkedId).getTag());
        bottomSheetBinding.typeGroup.setOnCheckedChangeListener(((group, checkedId) -> type = (String) group.findViewById(checkedId).getTag()));
        bottomSheetBinding.sortGroup.setOnCheckedChangeListener(((group, checkedId) -> sort = (String) group.findViewById(checkedId).getTag()));

    }
}
