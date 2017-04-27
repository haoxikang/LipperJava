package com.fallllllll.lipper.ui.login;

import android.widget.Button;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.network.model.OauthModel;
import com.fallllllll.lipper.utils.BaseRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by 康颢曦 on 2017/3/8.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApplication.class)
public class LoginActivityTest {
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Rule
    public BaseRule baseRule = new BaseRule(false);
    @Mock
    LoginContract.LoginView mockLoginView;


    @Mock
    LoginContract.LoginPresenter loginPresenter;


    @Test
    public void testLoginActivity() {

        ActivityController<LoginActivity> controller = Robolectric.buildActivity(LoginActivity.class);
        LoginActivity loginActivity = controller.get();


        LoginModule mockLoginModule = spy(new LoginModule(mockLoginView));
        loginActivity.setLoginModule(mockLoginModule);


        when(mockLoginModule.provideLoginPresenter(any(DribbbleModel.class), any(OauthModel.class))).thenReturn(loginPresenter);


        controller.create();
        verify(loginPresenter).attach();
        verify(loginPresenter).onPresenterCreate();

        Button loginButton = (Button) loginActivity.findViewById(R.id.login_button);
        System.out.print("" + loginButton.callOnClick());
        verify(loginPresenter).onLoginClick();


        controller.destroy();
        verify(loginPresenter).detach();


    }


}