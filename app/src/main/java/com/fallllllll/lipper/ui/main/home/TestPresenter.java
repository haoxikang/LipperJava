package com.fallllllll.lipper.ui.main.home;

import android.os.Handler;
import android.util.Log;

import com.fallllllll.lipper.ui.view.widget.GeneralRecyclerViewFragment.GeneralPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qqq34 on 2017/2/4.
 */

public class TestPresenter extends GeneralPresenter {


    @Override
    public void refreshData() {
        new Handler().postDelayed(() -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                list.add("ddd" + i);
            }
            refreshFinish(list);
            //    onRefreshError("加载失败");
        }, 2000);
    }

    @Override
    public void loadNextPageData(final int page) {
        Log.d(TAG, page + " ");
        new Handler().postDelayed(() -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                list.add("b" + page + "   " + i);
            }
            loadNextPageFinish(list);
            //  onLoadNextError("加载下一页失败");
        }, 2000);
    }
}
