package com.example.dribbble.data;

import com.example.dribbble.core.rxjava.exceptionalhandling.ApiException;
import com.example.dribbble.core.rxjava.exceptionalhandling.ConvertToApiException;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.local.user.UserToken;
import com.example.dribbble.data.network.MyNetworkInterceptor;
import com.example.dribbble.data.network.OauthHttpMethods;
import com.example.dribbble.data.network.model.OauthModel;
import com.example.dribbble.data.network.model.impl.OauthModelImpl;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by qqq34 on 2017/3/20.
 */
public class OauthServiceTest {

    UserToken mUserToken;
    Disposable mDisposable;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Mock
    UserHelper mUserHelper;
    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    OauthModel mOauthModel;

    @Before
    public void setup() {
        when(mUserHelper.isLogin()).thenReturn(false);
        mOauthModel = OauthModelImpl.getInstance(OauthHttpMethods.getInstance(new MyNetworkInterceptor(mUserHelper)).getService());
    }

    @Test
    public void getToken() throws Exception {
        mDisposable = mOauthModel.getToken(RequestBody.create(
                MediaType.parse("multipart/form-data"), "9abb27b45c049d8438e0f7ad751fc090d8817de7d34c623ea6590340ebacdab6"))
                .onErrorResumeNext(new ConvertToApiException<>())
                .subscribe(userToken -> {
                    mUserToken = userToken;
                }, throwable -> {
                    if (throwable instanceof ApiException) {
                        ApiException a = (ApiException) throwable;
                        System.out.print(a.message);
                    } else {
                        System.out.print("throwable" + throwable.getMessage());
                    }
                });
        assertNotNull(mUserToken);
    }
    @After
    public void testFinished() {


        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }

    }
}