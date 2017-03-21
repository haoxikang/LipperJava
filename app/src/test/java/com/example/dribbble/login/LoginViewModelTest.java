package com.example.dribbble.login;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.core.BaseRealmTest;
import com.example.dribbble.core.MyRobolectricTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;


/**
 * Created by qqq34 on 2017/3/13.
 */
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
public class LoginViewModelTest extends BaseRealmTest {
    @Override
    public void setup() throws Exception {
        super.setup();
    }

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