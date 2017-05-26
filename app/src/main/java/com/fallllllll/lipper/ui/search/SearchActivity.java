package com.fallllllll.lipper.ui.search;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.transition.Transition;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.activity.BaseActivity;
import com.fallllllll.lipper.utils.ImeUtils;
import com.fallllllll.lipper.utils.LogUtils;
import com.fallllllll.lipper.utils.MDStatusBarCompat;
import com.fallllllll.lipper.utils.UIUtils;

/**
 * Created by fallllllll on 2017/5/19/019.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class SearchActivity extends BaseActivity {
    private SearchView searchView;
    private ImageButton searchBack;
    private Transition transitionEnter;
    private Transition transitionExit;
    private Transition.TransitionListener transitionListener;
    private AnimatedVectorDrawable animatedVectorDrawable;


    @Override
    protected void initViewAndData() {
setContentView(R.layout.activity_search);
        MDStatusBarCompat.setImageTranslucent(this);
        findViewById(R.id.search_toolbar).setPadding(0, UIUtils.getStatusBarHeight(this), 0, 0);
        searchView = (SearchView) findViewById(R.id.search_view);
        searchBack = (ImageButton) findViewById(R.id.searchback);

    }


    @Override
    public void onEnterAnimationComplete() {
        // focus the search view once the enter transitionEnter finishes
        searchView.requestFocus();
        ImeUtils.showIme(searchView);
    }

    @Override
    protected void initListeners() {
        searchBack.setOnClickListener(v -> finishAfterTransition());

        transitionEnter = getWindow().getSharedElementEnterTransition();
        transitionListener = new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                animatedVectorDrawable = ((AnimatedVectorDrawable) searchBack.getDrawable());
                LogUtils.d(animatedVectorDrawable.toString());
                animatedVectorDrawable.start();
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                animatedVectorDrawable.stop();
         //       searchBack.setImageDrawable(getDrawable(R.drawable.search_icon_return));
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        };
        transitionEnter.addListener(transitionListener);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (transitionEnter != null) {
            transitionEnter.removeListener(transitionListener);
        }
        searchBack.setBackground(null);
    }
}
