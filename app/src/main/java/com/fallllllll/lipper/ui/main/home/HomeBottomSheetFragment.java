package com.fallllllll.lipper.ui.main.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.rxjava.RxBus;
import com.fallllllll.lipper.data.databean.eventBean.ShotsListFilterEvent;
import com.fallllllll.lipper.ui.view.widget.MultiLineRadioGroup;

/**
 * Created by fallllllll on 2017/5/10/010.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class HomeBottomSheetFragment extends BottomSheetDialogFragment {
    private static final String TIME_KEY = "HomeBottomSheetFragment.time";
    private static final String TYPE_KEY = "HomeBottomSheetFragment.type";
    private static final String SORT_KEY = "HomeBottomSheetFragment.sort";

    private String time;
    private String type;
    private String sort;

    private HomeBottomSheetFragmentStatus radioStatus;

    private MultiLineRadioGroup multiLineRadioGroupTime;
    private MultiLineRadioGroup multiLineRadioGroupSort;
    private MultiLineRadioGroup multiLineRadioGroupType;

    private AppCompatRadioButton timeRadio1, timeRadio2, timeRadio3, timeRadio4, timeRadio5;
    private AppCompatRadioButton sortRadio1, sortRadio2, sortRadio3, sortRadio4;
    private AppCompatRadioButton typeRadio1, typeRadio2, typeRadio3, typeRadio4, typeRadio5, typeRadio6, typeRadio7;

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
        View view = inflater.inflate(R.layout.fragment_home_bottom_sheet, container, false);
        initData();
        initView(view);
        initListener();
        return view;
    }


    private void initData() {
        time = getArguments().getString(TIME_KEY);
        type = getArguments().getString(TYPE_KEY);
        sort = getArguments().getString(SORT_KEY);
        radioStatus = new HomeBottomSheetFragmentStatus(getContext(), time, sort, type);

    }


    private void initView(View view) {

        multiLineRadioGroupTime = (MultiLineRadioGroup) view.findViewById(R.id.timeGroup);
        multiLineRadioGroupSort = (MultiLineRadioGroup) view.findViewById(R.id.sortGroup);
        multiLineRadioGroupType = (MultiLineRadioGroup) view.findViewById(R.id.typeGroup);

        timeRadio1 = (AppCompatRadioButton) view.findViewById(R.id.timeRadio1);
        timeRadio2 = (AppCompatRadioButton) view.findViewById(R.id.timeRadio2);
        timeRadio3 = (AppCompatRadioButton) view.findViewById(R.id.timeRadio3);
        timeRadio4 = (AppCompatRadioButton) view.findViewById(R.id.timeRadio4);
        timeRadio5 = (AppCompatRadioButton) view.findViewById(R.id.timeRadio5);

        sortRadio1 = (AppCompatRadioButton) view.findViewById(R.id.sortRadio1);
        sortRadio2 = (AppCompatRadioButton) view.findViewById(R.id.sortRadio2);
        sortRadio3 = (AppCompatRadioButton) view.findViewById(R.id.sortRadio3);
        sortRadio4 = (AppCompatRadioButton) view.findViewById(R.id.sortRadio4);

        typeRadio1 = (AppCompatRadioButton) view.findViewById(R.id.typeRadio1);
        typeRadio2 = (AppCompatRadioButton) view.findViewById(R.id.typeRadio2);
        typeRadio3 = (AppCompatRadioButton) view.findViewById(R.id.typeRadio3);
        typeRadio4 = (AppCompatRadioButton) view.findViewById(R.id.typeRadio4);
        typeRadio5 = (AppCompatRadioButton) view.findViewById(R.id.typeRadio5);
        typeRadio6 = (AppCompatRadioButton) view.findViewById(R.id.typeRadio6);
        typeRadio7 = (AppCompatRadioButton) view.findViewById(R.id.typeRadio7);

        timeRadio1.setText(radioStatus.listTime.get(0));
        timeRadio1.setChecked(radioStatus.time == AppConstants.INSTANCE.getNOW());

        timeRadio2.setText(radioStatus.listTime.get(1));
        timeRadio2.setChecked(AppConstants.INSTANCE.getWEEK().equals(radioStatus.time));

        timeRadio3.setText(radioStatus.listTime.get(2));
        timeRadio3.setChecked(AppConstants.INSTANCE.getMONTH().equals(radioStatus.time));

        timeRadio4.setText(radioStatus.listTime.get(3));
        timeRadio4.setChecked(AppConstants.INSTANCE.getYEAR().equals(radioStatus.time));

        timeRadio5.setText(radioStatus.listTime.get(4));
        timeRadio5.setChecked(AppConstants.INSTANCE.getEVER().equals(radioStatus.time));

        sortRadio1.setText(radioStatus.listSort.get(0));
        sortRadio1.setChecked(radioStatus.sort == AppConstants.INSTANCE.getPOPULARITY());

        sortRadio2.setText(radioStatus.listSort.get(1));
        sortRadio2.setChecked(AppConstants.INSTANCE.getRECENT().equals(radioStatus.sort));

        sortRadio3.setText(radioStatus.listSort.get(2));
        sortRadio3.setChecked(AppConstants.INSTANCE.getVIEWS().equals(radioStatus.sort));

        sortRadio4.setText(radioStatus.listSort.get(3));
        sortRadio4.setChecked(AppConstants.INSTANCE.getCOMENTS().equals(radioStatus.sort));

        typeRadio1.setText(radioStatus.listType.get(0));
        typeRadio1.setChecked(AppConstants.INSTANCE.getSHOTS() == radioStatus.type);

        typeRadio2.setText(radioStatus.listType.get(1));
        typeRadio2.setChecked(AppConstants.INSTANCE.getDEBUTS().equals(radioStatus.type));

        typeRadio3.setText(radioStatus.listType.get(2));
        typeRadio3.setChecked(AppConstants.INSTANCE.getTEAMS().equals(radioStatus.type));

        typeRadio4.setText(radioStatus.listType.get(3));
        typeRadio4.setChecked(AppConstants.INSTANCE.getPLAYOFFS().equals(radioStatus.type));

        typeRadio5.setText(radioStatus.listType.get(4));
        typeRadio5.setChecked(AppConstants.INSTANCE.getANIMATED().equals(radioStatus.type));

        typeRadio6.setText(radioStatus.listType.get(5));
        typeRadio6.setChecked(AppConstants.INSTANCE.getATTACHMENTS().equals(radioStatus.type));

        typeRadio7.setText(radioStatus.listType.get(6));
        typeRadio7.setChecked(AppConstants.INSTANCE.getREBOUNDS().equals(radioStatus.type));
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        RxBus.get().post(new ShotsListFilterEvent(time, sort, type));
        super.onDismiss(dialog);
    }

    private void initListener() {
        multiLineRadioGroupTime.setOnCheckedChangeListener((group, checkedId) -> time = (String) group.findViewById(checkedId).getTag());
        multiLineRadioGroupType.setOnCheckedChangeListener(((group, checkedId) -> type = (String) group.findViewById(checkedId).getTag()));
        multiLineRadioGroupSort.setOnCheckedChangeListener(((group, checkedId) -> sort = (String) group.findViewById(checkedId).getTag()));

    }
}
