package com.fallllllll.lipper.ui.main.home;


import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.utils.BaseRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * Created by fallllllll on 2017/5/12/012.
 * GitHub :  https://github.com/348476129/Lipper
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApplication.class)
public class ShotsActivityTest {
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Rule
    public BaseRule baseRule = new BaseRule(true);

    @Mock
    private
    ShotsActivityContract.ShotsActivityPresenter presenter;


    @Test
    public void testShotsFragment() {


        ActivityController controller = Robolectric.buildActivity(ShotsActivity.class);
        ShotsActivity shotsActivity = (ShotsActivity) controller.get();
        shotsActivity.setPresenter(presenter);
        controller.create();

        verify(presenter).attach();


        RoboMenuItem roboMenuItem = new RoboMenuItem(R.id.filter_list);
        shotsActivity.onOptionsItemSelected(roboMenuItem);
        RoboMenuItem layoutMenu = new RoboMenuItem(R.id.shots_menu_layout);
        shotsActivity.onOptionsItemSelected(layoutMenu);
        verify(presenter).showBottomSheet();
        assertNotNull(shotsActivity.popWindow.isShowing());

    }

}