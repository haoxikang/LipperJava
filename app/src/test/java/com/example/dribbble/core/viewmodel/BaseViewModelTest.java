package com.example.dribbble.core.viewmodel;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.R;
import com.example.dribbble.TestApplication;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.OauthModel;
import com.example.dribbble.login.LoginActivity;
import com.example.dribbble.login.LoginModule;
import com.example.dribbble.login.LoginViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2017/4/19/019.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApplication.class)
public class BaseViewModelTest {
    BaseViewModel baseViewModel;
    @Before
    public  void setUp(){
      baseViewModel = new BaseViewModel(RuntimeEnvironment.application.getApplicationContext());
    }

    @Test
    public void showToast() throws Exception {
        baseViewModel.showToast("test");
            assertEquals(ShadowToast.getTextOfLatestToast(),"test");
    }

    @Test
    public void getString() throws Exception {
        String s = baseViewModel.getString(R.string.app_name);
        assertNotNull(s);
    }

}