package com.fallllllll.dribbble.core.viewmodel;

import com.fallllllll.dribbble.BuildConfig;
import com.fallllllll.dribbble.R;
import com.fallllllll.dribbble.TestApplication;
import com.fallllllll.dribbble.core.MyRobolectricTestRunner;
import com.fallllllll.dribbble.ui.login.LoginActivity;
import com.fallllllll.dribbble.ui.login.LoginModule;
import com.fallllllll.dribbble.ui.login.LoginViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;

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