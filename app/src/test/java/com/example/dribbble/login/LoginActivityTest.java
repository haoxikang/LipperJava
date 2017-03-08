package com.example.dribbble.login;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.dagger.AppComponent;
import com.example.dribbble.dagger.AppModule;
import com.example.dribbble.dagger.DaggerAppComponent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;


/**
 * Created by 康颢曦 on 2017/3/8.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityTest {

    @Test
   public void testActivityStart(){
        LoginView mockLoginView = mock(LoginView.class);
        AppModule mockAppModule = spy(new AppModule(RuntimeEnvironment.application));
        AppComponent appComponent = DaggerAppComponent.builder().appModule(mockAppModule).build();
        LoginModule mockLoginModule = spy(new LoginModule(mockLoginView));


    }

}