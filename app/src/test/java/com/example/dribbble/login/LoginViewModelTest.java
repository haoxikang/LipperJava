package com.example.dribbble.login;

import android.content.Context;
import android.content.Intent;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.core.MyRobolectricTestRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowApplication;

import static org.junit.Assert.assertEquals;


/**
 * Created by qqq34 on 2017/3/13.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = DribbbleApplication.class)
public class LoginViewModelTest {
    @Test
    public void goWebActivityForResult() throws Exception {
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        LoginViewModel loginViewModel = new LoginViewModel(loginActivity);
        loginViewModel.GoWebActivityForResult();

        Intent expectedIntent = new Intent(loginActivity, LoginWebActivity.class);

        ShadowActivity shadowActivity = Shadows.shadowOf(loginActivity);
        ShadowActivity.IntentForResult actualIntent = shadowActivity.getNextStartedActivityForResult();
        assertEquals(actualIntent.requestCode, LoginActivity.LOGIN_REQUEST_CODE);
    }


}