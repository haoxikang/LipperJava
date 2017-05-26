package com.fallllllll.lipper.ui.main.homelist;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

import com.fallllllll.lipper.DribbbleApplication;
import com.fallllllll.lipper.utils.UIUtils;

/**
 * Created by fallllllll on 2017/5/3/003.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ShotsListLayoutEnum {
    public static int GRID_LAYOUT = 0;
    public static int ONLY_IMAGE_LAYOUT = 1;
    public static int LINEAR_LAYOUT = 2;
    private int currentLayout = LINEAR_LAYOUT;


    public ShotsListLayoutEnum(int currentLayout) {
        this.currentLayout = currentLayout;
    }

    public int getCurrentLayout() {
        return currentLayout;
    }

    public void setCurrentLayout(int currentLayout) {
        this.currentLayout = currentLayout;
    }
}