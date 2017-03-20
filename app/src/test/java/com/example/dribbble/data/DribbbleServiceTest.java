package com.example.dribbble.data;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.core.rxjava.exceptionalhandling.ApiException;
import com.example.dribbble.core.rxjava.exceptionalhandling.ConvertToApiException;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.local.user.LipperUser;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.BaseHttpMethods;
import com.example.dribbble.data.network.DribbbleHttpMethods;
import com.example.dribbble.data.network.MyNetworkInterceptor;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.data.local.user.UserToken;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.annotation.Config;

import java.util.List;

import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by qqq34 on 2017/3/9.
 */
public class DribbbleServiceTest {
    DribbbleModel mDribbbleModel;
    Disposable mDisposable;
    List<ShotBean> list;
    LipperUser mLipperUser;
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Mock
    UserHelper mUserHelper;
    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();


    @Before
    public void setup() {

        UserToken userToken = new UserToken();
        userToken.setAccess_token("a9d9a7332cc3454a651bfd3f245e6e6bc04087fcc381b4f469af31f342e9a86f");
        when(mUserHelper.isLogin()).thenReturn(true);
        when(mUserHelper.getToken()).thenReturn(userToken);
        mDribbbleModel = DribbbleModelImpl.getInstance(DribbbleHttpMethods.getInstance(new MyNetworkInterceptor(mUserHelper)).getService());

    }

    @Test
    public void getUserInfo() throws Exception {
        mDisposable = mDribbbleModel.getUserInfo()
                .onErrorResumeNext(new ConvertToApiException<>())
                .subscribe(lipperUser -> {
                    mLipperUser = lipperUser;
                }, throwable -> {
                    if (throwable instanceof ApiException) {
                        ApiException a = (ApiException) throwable;
                        System.out.print(a.message);
                    } else {
                        System.out.print("throwable" + throwable.getMessage());
                    }
                });
        assertNotNull(mLipperUser);
    }


    @Test
    public void testShotApi() {
        mDisposable = mDribbbleModel.getShot("animated", "week")
                .onErrorResumeNext(new ConvertToApiException<>())
                .subscribe(testList -> {
                    list = testList;
                }, throwable -> {
                    if (throwable instanceof ApiException) {
                        ApiException a = (ApiException) throwable;
                        System.out.print(a.message);
                    } else {
                        System.out.print(throwable.getMessage());
                    }
                });
        assertNotNull(list);
    }

    @After
    public void testFinished() {


        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }

    }
}
