package com.fallllllll.lipper.ui.main.homelist;

import com.fall.generalrecyclerviewfragment.GeneralContract;
import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.core.rxjava.RxBus;
import com.fallllllll.lipper.data.databean.eventBean.ShotsListFilterEvent;
import com.fallllllll.lipper.data.databean.eventBean.ShotsMenuLayoutEvent;
import com.fallllllll.lipper.data.network.model.impl.DribbbleModelImpl;
import com.fallllllll.lipper.utils.BaseRule;
import com.fallllllll.lipper.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
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

/**
 * Created by Administrator on 2017/5/8/008.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = TestApplication.class)
public class ShotsListPresenterImplTest {

    ShotsListPresenterImpl presenter;
    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();
    @Rule
    public BaseRule baseRule = new BaseRule(false);
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Mock
    GeneralContract.View view;

    @Mock
    ShotsListContract.ShotsListView shotsListView;

    @Before
    public void setup() {
        presenter = spy(new ShotsListPresenterImpl(DribbbleModelImpl.getInstance(), shotsListView));
        presenter.attach();
        presenter.setView(view);
    }

    @Test
    public void refreshData() throws Exception {
        presenter.refreshData();
        verify(presenter).refreshFinish(any());
        verify(view).closeLoadAnimation();
        verify(view).refreshFinish(any());
    }

    @Test
    public void loadNextPageData() throws Exception {
        presenter.loadNextPageData(2);
        verify(presenter).loadNextPageFinish(any());
        verify(view).closeLoadAnimation();
        verify(view).loadNextDataFinish(any());

    }

    @Test
    public void RxBuxTest(){
        presenter.initRxBus();
        RxBus.get().post(new ShotsListFilterEvent(AppConstants.INSTANCE.getNOW(), AppConstants.INSTANCE.getPOPULARITY(), AppConstants.INSTANCE.getSHOTS()));
        verify(presenter).checkAndRefreshData();
        verify(presenter).stopLoading();
        RxBus.get().post(new ShotsMenuLayoutEvent(AppConstants.INSTANCE.getSHOTS_LAYOUT_ONLY_IMAGE()));
        verify(presenter).setListLayout(any());
    }
    @After
    public void afterTest() {
        presenter.detach();
    }
}