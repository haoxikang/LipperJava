package com.fallllllll.lipper.ui.main.homelist;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.utils.BaseRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.annotation.Config;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

/**
 * Created by Administrator on 2017/4/28/028.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = TestApplication.class)
public class ShotsListFragmentTest {
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Rule
    public BaseRule baseRule = new BaseRule(true);
    @Mock
    AbstractShotListPresenter presenter;
    @Mock
    ShotsListContract.ShotsListView shotsListView;

    @Test
    public void textShotsListFragment() {
        ShotsListFragment shotsListFragment = new ShotsListFragment();
        ShotsListModule mockShotsListModule = spy(new ShotsListModule(shotsListView));
        shotsListFragment.setShotsListModule(mockShotsListModule);
        when(mockShotsListModule.provideShotsListPresenter(any(DribbbleModel.class))).thenReturn(presenter);
        startFragment(shotsListFragment);
        verify(presenter).attach();
        verify(presenter).onPresenterCreate();
    }
}