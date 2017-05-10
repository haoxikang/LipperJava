package com.fallllllll.lipper.ui.main.home;

import android.content.Context;
import android.databinding.ObservableField;

import com.fallllllll.lipper.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10/010.
 */

public class HomeBottomSheetFragmentViewModel {
    private Context context;
    public List<String> listTime;
    public List<String> listSort;
    public List<String> listType;


    public String time;
    public String sort;
    public String type;

    public HomeBottomSheetFragmentViewModel(Context context, String time, String sort, String type) {
        this.context = context;
        listTime = Arrays.asList(this.context.getResources().getStringArray(R.array.time));
        listSort = Arrays.asList(this.context.getResources().getStringArray(R.array.sort));
        listType = Arrays.asList(this.context.getResources().getStringArray(R.array.type));

        this.time = time;
        this.sort = sort;
        this.type = type;
    }

}
