package com.example.dribbble.login;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.DribbbleHttpMethods;
import com.example.dribbble.data.network.MyNetworkInterceptor;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.utils.BaseRule;
import com.example.dribbble.utils.RxSchedulersOverrideRule;
import com.example.dribbble.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by 康颢曦 on 2017/3/9.
 */
public class LoginPresenterTest {

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();
    @Rule
    public  BaseRule baseRule = new BaseRule();
    @Mock
    LoginView mockLoginView;

    DribbbleModel mDribbbleModel;

    LoginPresenter mLoginPresenter;

    UserHelper mUserHelper;
    @Before
    public void setup() {
        mDribbbleModel = DribbbleModelImpl.getInstance();
        mLoginPresenter = new LoginPresenter(mDribbbleModel, mockLoginView);
        mLoginPresenter.attach();
    }

    @Test
    public void TestOnPresenterCreate() {

        ArgumentCaptor<ShotBean> captor = ArgumentCaptor.forClass(ShotBean.class);

        mLoginPresenter.onPresenterCreate();
        verify(mockLoginView).onDataFetch(captor.capture());

        ShotBean test = captor.getValue();
        System.out.print(test.getTitle());

    }

    @After
    public void afterTest() {
        mLoginPresenter.detach();
    }

}