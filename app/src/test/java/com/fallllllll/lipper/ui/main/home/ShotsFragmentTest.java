package com.fallllllll.lipper.ui.main.home;


import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.core.TestFragmentActivity;
import com.fallllllll.lipper.utils.BaseRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

/**
 * Created by Administrator on 2017/5/12/012.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = TestApplication.class)
public class ShotsFragmentTest {
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Rule
    public BaseRule baseRule = new BaseRule(true);

    @Mock
    ShotsFragmentContract.ShotsFragmentPresenter presenter;


    @Test
    public void testShotsFragment() {

        ShotsFragment shotsFragment = new ShotsFragment();
        shotsFragment.setPresenter(presenter);
        startFragment(shotsFragment, TestFragmentActivity.class);
        verify(presenter).attach();

        RoboMenuItem roboMenuItem = new RoboMenuItem(R.id.filter_list);
        shotsFragment.onOptionsItemSelected(roboMenuItem);
        RoboMenuItem layoutMenu = new RoboMenuItem(R.id.shots_menu_layout);
        shotsFragment.onOptionsItemSelected(layoutMenu);
        verify(presenter).showBottomSheet();
        assertNotNull(shotsFragment.popWindow.isShowing());


    }

}