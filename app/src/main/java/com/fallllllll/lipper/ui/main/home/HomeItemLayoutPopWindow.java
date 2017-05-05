package com.fallllllll.lipper.ui.main.home;

import android.app.Activity;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.databinding.ViewHomeItemPopupWindowBinding;

/**
 * Created by Administrator on 2017/5/5/005.
 */

public class HomeItemLayoutPopWindow extends PopupWindow {
    ViewHomeItemPopupWindowBinding binding;
    public HomeItemLayoutPopWindow(Activity activity){
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.view_home_item_popup_window,null,false);
        this.setContentView(binding.getRoot());
        this.setFocusable(true);
        this.update();
        ColorDrawable dw = new ColorDrawable(0000000000);
        this.setBackgroundDrawable(dw);
    }
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }
}
