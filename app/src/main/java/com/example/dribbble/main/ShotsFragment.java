package com.example.dribbble.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.example.dribbble.R;
import com.example.dribbble.core.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public class ShotsFragment extends BaseFragment {

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void inject() {

    }

    @Override
    protected View initView(@Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("aaaaaaa");
        textView.setTextSize(20);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.primary_text));
        return textView;
    }

    @Override
    public void initListeners() {

    }
}
