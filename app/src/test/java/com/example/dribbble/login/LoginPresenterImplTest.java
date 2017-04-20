package com.example.dribbble.login;

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
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.verify;

/**
 * Created by 康颢曦 on 2017/3/9.
 */
public class LoginPresenterImplTest {


    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();
     @Rule
    public BaseRule baseRule = new BaseRule(true);
    @Mock
    LoginContract.LoginView mockLoginView;

    DribbbleModel mDribbbleModel;

    OauthModel oauthModel;

    LoginContract.LoginPresenter loginPresenter;
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
     //   UserManager.INSTANCE.init(TestUtils.getLoginMockUserHelper());
        mDribbbleModel = DribbbleModelImpl.getInstance();
        oauthModel = OauthModelImpl.getInstance();
        loginPresenter = new LoginPresenterImpl(mDribbbleModel, oauthModel, mockLoginView);
        loginPresenter.attach();
    }


    @Test
    public void TestOnPresenterCreate() {
        loginPresenter.onPresenterCreate();
       verify(mockLoginView).setButtonEnable(anyBoolean());
        verify(mockLoginView).showTopDialog(any());
        verify(mockLoginView).hideAllTopDialog();
        verify(mockLoginView).goMainActivity();
        verify(mockLoginView).finishActivity();


//        ArgumentCaptor<ShotBean> captor = ArgumentCaptor.forClass(ShotBean.class);
//
//        loginPresenter.onPresenterCreate();
//        verify(mockLoginView).onDataFetch(any());
//
//        ShotBean test = captor.getValue();
//        System.out.print(test.getTitle());

    }

    @After
    public void afterTest() {
        loginPresenter.detach();
    }

}