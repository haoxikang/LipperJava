package com.example.dribbble.login;

import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.OauthModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.data.network.model.impl.OauthModelImpl;
import com.example.dribbble.utils.BaseRule;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

/**
 * Created by 康颢曦 on 2017/3/9.
 */
public class LoginPresenterImplTest {

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();
    @Rule
    public BaseRule baseRule = new BaseRule();
    @Mock
    LoginContract.LoginView mockLoginView;

    DribbbleModel mDribbbleModel;

    OauthModel oauthModel;

    LoginContract.LoginPresenter loginPresenter;

    @Before
    public void setup() {
        mDribbbleModel = DribbbleModelImpl.getInstance();
        oauthModel = OauthModelImpl.getInstance();
        loginPresenter = new LoginPresenterImpl(mDribbbleModel, oauthModel, mockLoginView);
        loginPresenter.attach();
    }

    @Test
    public void TestOnPresenterCreate() {

        ArgumentCaptor<ShotBean> captor = ArgumentCaptor.forClass(ShotBean.class);

        loginPresenter.onPresenterCreate();
        verify(mockLoginView).onDataFetch(captor.capture());

        ShotBean test = captor.getValue();
        System.out.print(test.getTitle());

    }

    @After
    public void afterTest() {
        loginPresenter.detach();
    }

}