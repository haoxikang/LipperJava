package com.fallllllll.lipper.ui.login;

import android.content.Intent;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.network.model.OauthModel;
import com.fallllllll.lipper.ui.main.MainActivity;
import com.fallllllll.lipper.utils.BaseRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.ActivityController;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;


/**
 * Created by 康颢曦 on 2017/3/13.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApplication.class)
public class LoginViewModelTest {
    @Test
    public void goMainAcitivity() throws Exception {
    }

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public BaseRule baseRule = new BaseRule(false);

    LoginActivity loginActivity;
    LoginViewModel loginViewModel;

    @Mock
    LoginContract.LoginPresenter loginPresenter;

    @Before
    public void setUp() {
        ActivityController<LoginActivity> controller = Robolectric.buildActivity(LoginActivity.class);
        loginActivity = controller.get();
        loginViewModel = new LoginViewModel(loginActivity);
        LoginModule mockLoginModule = spy(new LoginModule(loginViewModel));
        loginActivity.setLoginModule(mockLoginModule);
        when(mockLoginModule.provideLoginPresenter(any(DribbbleModel.class), any(OauthModel.class))).thenReturn(loginPresenter);
        controller.create().start().resume();
    }

    @Test
    public void goWebActivityForResult() throws Exception {

        loginViewModel.goWebActivityForResult();

        ShadowActivity shadowActivity = shadowOf(loginActivity);
        ShadowActivity.IntentForResult actualIntent = shadowActivity.getNextStartedActivityForResult();
        assertEquals(actualIntent.requestCode, LoginActivity.LOGIN_REQUEST_CODE);
    }

    @Test
    public void goMainActivity() {
        loginViewModel.goMainActivity();
        Intent intent = new Intent(loginActivity, MainActivity.class);
        ShadowActivity shadowActivity = shadowOf(loginActivity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertEquals(intent.toString(), actualIntent.toString());

    }

}