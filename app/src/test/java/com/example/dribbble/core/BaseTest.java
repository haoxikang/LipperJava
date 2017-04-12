package com.example.dribbble.core;

import android.text.TextUtils;

import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.dagger.AppComponent;
import com.example.dribbble.dagger.AppModule;
import com.example.dribbble.dagger.DaggerAppComponent;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.DribbbleHttpMethods;
import com.example.dribbble.data.network.MyNetworkInterceptor;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.utils.TestUtils;

import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;

import static org.mockito.Mockito.when;

/**
 * Created by qqq34 on 2017/3/9.
 */
public abstract class BaseTest {
    private AppComponent mAppComponent;
    AppModule appModule;
    UserHelper userHelper;

    @Before
    public void beforeTest() {

        appModule = Mockito.mock(AppModule.class);
        userHelper = getUserHelper();
        Mockito.when(appModule.provideDribbbleModel()).thenReturn(DribbbleModelImpl.getInstance(DribbbleHttpMethods.getInstance(new MyNetworkInterceptor(userHelper)).getService()));
        Mockito.when(appModule.provideContext()).thenReturn(RuntimeEnvironment.application);
        mAppComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
        ((DribbbleApplication) RuntimeEnvironment.application).setAppComponent(mAppComponent);
    }

    protected UserHelper getUserHelper() {
        return TestUtils.getDefaultMockUserHelper();
    }
}
