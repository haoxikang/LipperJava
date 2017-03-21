package com.example.dribbble.login;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.DribbbleHttpMethods;
import com.example.dribbble.data.network.MyNetworkInterceptor;
import com.example.dribbble.data.network.OauthHttpMethods;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.data.network.model.impl.OauthModelImpl;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.util.MockitoLogger;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.annotation.Config;


import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.internal.RealmCore;
import io.realm.log.RealmLog;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by qqq34 on 2017/3/9.
 */
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*", "retrofit2.*", "okhttp3.*"})
public class LoginPresenterTest {

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Mock
    LoginView mockLoginView;

    DribbbleModel mDribbbleModel;

    LoginPresenter mLoginPresenter;
    @Mock
    UserHelper mUserHelper;
    @Before
    public void setup() {
        when(mUserHelper.isLogin()).thenReturn(false);
        mDribbbleModel = DribbbleModelImpl.getInstance(DribbbleHttpMethods.getInstance(new MyNetworkInterceptor(mUserHelper)).getService());
        mLoginPresenter = new LoginPresenter(mDribbbleModel, mockLoginView);
        mLoginPresenter.attach();
    }

    @Test
    public void TestOnPresenterCreate() {

        ArgumentCaptor<ShotBean> captor = ArgumentCaptor.forClass(ShotBean.class);

        mLoginPresenter.onPresenterCreate();
        verify(mockLoginView).onDataFetch(captor.capture());

        ShotBean test = captor.getValue();
        System.out.print(test.getTitle());

    }

    @After
    public void afterTest() {
        mLoginPresenter.detach();
    }

}