package com.fallllllll.lipper.ui.login;

import android.content.Intent;
import android.widget.Button;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.network.model.OauthModel;
import com.fallllllll.lipper.ui.main.home.ShotsActivity;
import com.fallllllll.lipper.utils.BaseRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;


/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = TestApplication.class)
public class LoginActivityTest {
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Rule
    public BaseRule baseRule = new BaseRule(false);
    @Mock
    LoginContract.LoginView mockLoginView;


    @Mock
    LoginContract.LoginPresenter loginPresenter;

    private LoginActivity loginActivity;
    private ActivityController controller;

    @Before
    public void setUp() {
        controller = Robolectric.buildActivity(LoginActivity.class);
        loginActivity = (LoginActivity) controller.get();
        LoginModule mockLoginModule = spy(new LoginModule(mockLoginView));
        loginActivity.setLoginModule(mockLoginModule);
        when(mockLoginModule.provideLoginPresenter(any(DribbbleModel.class), any(OauthModel.class))).thenReturn(loginPresenter);
        controller.create().start().resume();
    }

    @Test
    public void testLoginActivity() {


        verify(loginPresenter).attach();
        verify(loginPresenter).onPresenterCreate();

        Button loginButton = (Button) loginActivity.findViewById(R.id.login_button);
        System.out.print("" + loginButton.callOnClick());
        verify(loginPresenter).onLoginClick();


        controller.destroy();
        verify(loginPresenter).detach();


    }

    @Test
    public void goWebActivityForResult() throws Exception {

        loginActivity.goWebActivityForResult();

        ShadowActivity shadowActivity = shadowOf(loginActivity);
        ShadowActivity.IntentForResult actualIntent = shadowActivity.getNextStartedActivityForResult();
        assertEquals(actualIntent.requestCode, LoginActivity.LOGIN_REQUEST_CODE);
    }

    @Test
    public void goMainActivity() {
        loginActivity.goMainActivity();
        Intent intent = new Intent(loginActivity, ShotsActivity.class);
        ShadowActivity shadowActivity = shadowOf(loginActivity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertEquals(intent.toString(), actualIntent.toString());

    }

}