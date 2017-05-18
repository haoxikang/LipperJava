package com.fallllllll.lipper.ui.main.home;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.utils.BaseRule;
import com.fallllllll.lipper.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.annotation.Config;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by fallllllll on 2017/5/15/015.
 * GitHub :  https://github.com/348476129/Lipper
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = TestApplication.class)
public class ShotsActivityPresenterTest {
    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();
    @Rule
    public BaseRule baseRule = new BaseRule(false);
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Mock
    ShotsActivityContract.ShotsActivityView view;
    ShotsActivityPresenter shotsFragmentPresenter;
    @Test
    public void showBottomSheet() throws Exception {
         shotsFragmentPresenter = new ShotsActivityPresenter(view);
        shotsFragmentPresenter.attach();
        shotsFragmentPresenter.showBottomSheet();
        verify(view).showBottomSheet(any());
    }
    @After
    public void afterTest() {
        shotsFragmentPresenter.detach();
    }
}