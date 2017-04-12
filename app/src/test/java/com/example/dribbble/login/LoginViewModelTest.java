package com.example.dribbble.login;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.core.BaseTest;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.DribbbleHttpMethods;
import com.example.dribbble.data.network.MyNetworkInterceptor;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;

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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


/**
 * Created by qqq34 on 2017/3/13.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = DribbbleApplication.class)
public class LoginViewModelTest extends BaseTest{

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();


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