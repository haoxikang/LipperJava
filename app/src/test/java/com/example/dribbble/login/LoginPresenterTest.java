package com.example.dribbble.login;

import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by qqq34 on 2017/3/9.
 */
public class LoginPresenterTest {

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Mock
    LoginView mockLoginView;

    DribbbleModel mDribbbleModel;

    LoginPresenter mLoginPresenter;

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