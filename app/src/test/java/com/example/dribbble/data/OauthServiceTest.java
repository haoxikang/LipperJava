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
import com.example.dribbble.utils.TestUtils;

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

    UserHelper mUserHelper;
    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    OauthModel mOauthModel;

    @Before
    public void setup() {
      mUserHelper = TestUtils.getDefaultMockUserHelper();
        mOauthModel = OauthModelImpl.getInstance(OauthHttpMethods.getInstance(new MyNetworkInterceptor(mUserHelper)).getService());
    }

    @Test
    public void getToken() throws Exception {
        mDisposable = mOauthModel.getToken(RequestBody.create(
                MediaType.parse("multipart/form-data"), "d4a82528cc596ed597277a96922dbcfc34f09dfdebf5de4da22efcfd659dc05c"))
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