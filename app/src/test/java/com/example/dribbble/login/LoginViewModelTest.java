package com.example.dribbble.login;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.TestApplication;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.OauthModel;
import com.example.dribbble.utils.BaseRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowDialog;
import org.robolectric.util.ActivityController;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


/**
 * Created by 康颢曦 on 2017/3/13.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApplication.class)
public class LoginViewModelTest {
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public BaseRule baseRule = new BaseRule();

    LoginActivity loginActivity;
    LoginViewModel loginViewModel ;

    @Mock
    LoginContract.LoginPresenter loginPresenter;
    @Before
    public  void setUp(){
        ActivityController<LoginActivity> controller = Robolectric.buildActivity(LoginActivity.class);
         loginActivity = controller.get();
        loginViewModel = new LoginViewModel(loginActivity);
        LoginModule mockLoginModule = spy(new LoginModule(loginViewModel));
        loginActivity.setLoginModule(mockLoginModule);
        when(mockLoginModule.provideLoginPresenter(any(DribbbleModel.class),any(OauthModel.class))).thenReturn(loginPresenter);
        controller.create();
    }

    @Test
    public void goWebActivityForResult() throws Exception {

        loginViewModel.GoWebActivityForResult();

        ShadowActivity shadowActivity = Shadows.shadowOf(loginActivity);
        ShadowActivity.IntentForResult actualIntent = shadowActivity.getNextStartedActivityForResult();
        assertEquals(actualIntent.requestCode, LoginActivity.LOGIN_REQUEST_CODE);


    }


}