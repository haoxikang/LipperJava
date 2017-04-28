package com.fallllllll.lipper.core.viewmodel;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;

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
 * Created by fallllllll on 2017/4/19/019.
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