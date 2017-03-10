package com.example.dribbble.login;

import android.widget.Button;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.R;
import com.example.dribbble.core.BaseTest;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.data.network.model.DribbbleModel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by 康颢曦 on 2017/3/8.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = DribbbleApplication.class)
public class LoginActivityTest extends BaseTest {

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Mock
    LoginView mockLoginView;

    @Mock
    LoginPresenter mockLoginPresenter;


    @Test
    public void testActivityStart() {
        ActivityController<LoginActivity> controller = Robolectric.buildActivity(LoginActivity.class);
        LoginActivity loginActivity = controller.get();


        LoginModule mockLoginModule = spy(new LoginModule(mockLoginView));
        loginActivity.setLoginModule(mockLoginModule);


        when(mockLoginModule.provideLoginPresenter(any(DribbbleModel.class))).thenReturn(mockLoginPresenter);


        controller.create();
        verify(mockLoginPresenter).attach();
        verify(mockLoginPresenter).onPresenterCreate();

        Button loginButton = (Button) loginActivity.findViewById(R.id.login_button);
      System.out.print(""+loginButton.performClick());
        verify(mockLoginPresenter).onLoginClick();


        controller.destroy();
        verify(mockLoginPresenter).detach();


    }

}