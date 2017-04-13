package com.example.dribbble.login;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.TestApplication;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.utils.BaseRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;


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


    @Test
    public void goWebActivityForResult() throws Exception {
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        LoginViewModel loginViewModel = new LoginViewModel(loginActivity);
        loginViewModel.GoWebActivityForResult();


        ShadowActivity shadowActivity = Shadows.shadowOf(loginActivity);
        ShadowActivity.IntentForResult actualIntent = shadowActivity.getNextStartedActivityForResult();
        assertEquals(actualIntent.requestCode, LoginActivity.LOGIN_REQUEST_CODE);
    }


}