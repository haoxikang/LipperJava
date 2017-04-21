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

/**
 * Created by Administrator on 2017/4/21/021.
 */

public class UserFragment extends BaseFragment {

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void inject() {

    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("用户");
        textView.setTextSize(20);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.primary_text));
        return textView;
    }

    @Override
    public void initListeners() {

    }
}

