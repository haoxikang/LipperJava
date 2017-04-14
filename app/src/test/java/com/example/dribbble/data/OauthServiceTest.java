package com.example.dribbble.data;

import com.example.dribbble.core.rxjava.exceptionalhandling.ApiException;
import com.example.dribbble.core.rxjava.exceptionalhandling.ConvertToApiException;
import com.example.dribbble.data.local.user.UserToken;
import com.example.dribbble.data.network.model.impl.OauthModelImpl;
import com.example.dribbble.utils.BaseRule;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static org.junit.Assert.assertNotNull;

/**
 * Created by 康颢曦 on 2017/3/20.
 */
public class OauthServiceTest {

    UserToken mUserToken;
    Disposable mDisposable;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Rule
    public BaseRule baseRule = new BaseRule();


//    @Test
//    public void getToken() throws Exception {
//        mDisposable = OauthModelImpl.getInstance().getToken("d2cebd4a3e8ab4107520e0f5a8934fba27762bae80d6714bbf3426ff265a4b4a")
//                .onErrorResumeNext(new ConvertToApiException<>())
//                .subscribe(userToken -> {
//                    mUserToken = userToken;
//                    System.out.print("throwable" + mUserToken.getAccess_token());
//                }, throwable -> {
//                    if (throwable instanceof ApiException) {
//                        ApiException a = (ApiException) throwable;
//                        System.out.print(a.message);
//                    } else {
//                        System.out.print("throwable" + throwable.getMessage());
//                    }
//                });
//        assertNotNull(mUserToken);
//    }

    @After
    public void testFinished() {


        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }

    }
}