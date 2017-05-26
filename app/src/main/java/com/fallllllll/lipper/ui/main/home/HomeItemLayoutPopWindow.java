package com.fallllllll.lipper.ui.main.home;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.rxjava.RxBus;
import com.fallllllll.lipper.data.databean.eventBean.ShotsMenuLayoutEvent;
import com.fallllllll.lipper.databinding.ViewHomeItemPopupWindowBinding;

import static com.fallllllll.lipper.core.constants.AppConstants.SHOTS_LAYOUT_LARGE;
import static com.fallllllll.lipper.core.constants.AppConstants.SHOTS_LAYOUT_ONLY_IMAGE;
import static com.fallllllll.lipper.core.constants.AppConstants.SHOTS_LAYOUT_SMALL;

/**
 * Created by fallllllll on 2017/5/5/005.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class HomeItemLayoutPopWindow extends PopupWindow {

    public HomeItemLayoutPopWindow(Activity activity) {
        View view = LayoutInflater.from(activity).inflate(R.layout.view_home_item_popup_window, null, false);
        this.setContentView(view);
        this.setFocusable(true);
        this.update();
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        ColorDrawable dw = new ColorDrawable(Color.parseColor("#00000000"));
        this.setBackgroundDrawable(dw);
        initListener(view);
    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, 0, 0, Gravity.END);
        } else {
            this.dismiss();
        }
    }

    private void initListener(View view) {
        view.findViewById(R.id.home_popup_large_layout).setOnClickListener(v -> {
            RxBus.get().post(new ShotsMenuLayoutEvent(SHOTS_LAYOUT_LARGE));
            this.dismiss();
        });
        view.findViewById(R.id.home_popup_small_layout).setOnClickListener(v -> {
            RxBus.get().post(new ShotsMenuLayoutEvent(SHOTS_LAYOUT_SMALL));
            this.dismiss();
        });
        view.findViewById(R.id.home_popup_only_image_layout).setOnClickListener(v -> {
            RxBus.get().post(new ShotsMenuLayoutEvent(SHOTS_LAYOUT_ONLY_IMAGE));
            this.dismiss();
        });
    }
}
