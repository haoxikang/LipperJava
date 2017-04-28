package com.fallllllll.lipper.ui.login;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.network.model.OauthModel;
import com.fallllllll.lipper.data.network.model.impl.DribbbleModelImpl;
import com.fallllllll.lipper.data.network.model.impl.OauthModelImpl;
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
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.verify;

/**
 * Created by fallllllll on 2017/3/9.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApplication.class)
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



    }

    @After
    public void afterTest() {
        loginPresenter.detach();
    }

}