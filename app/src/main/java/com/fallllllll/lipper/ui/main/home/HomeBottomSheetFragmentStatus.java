package com.fallllllll.lipper.ui.main.home;

import android.content.Context;

import com.fallllllll.lipper.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fallllllll on 2017/5/10/010.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class HomeBottomSheetFragmentStatus {
    public List<String> listTime;
    public List<String> listSort;
    public List<String> listType;


    public String time;
    public String sort;
    public String type;

    public HomeBottomSheetFragmentStatus(Context context, String time, String sort, String type) {
        listTime = Arrays.asList(context.getResources().getStringArray(R.array.time));
        listSort = Arrays.asList(context.getResources().getStringArray(R.array.sort));
        listType = Arrays.asList(context.getResources().getStringArray(R.array.type));

        this.time = time;
        this.sort = sort;
        this.type = type;
    }

}
