package com.example.dribbble.data;

import com.example.dribbble.core.rxjava.exceptionalhandling.ApiException;
import com.example.dribbble.core.rxjava.exceptionalhandling.ConvertToApiException;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.local.user.LipperUser;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.local.user.UserToken;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.utils.BaseRule;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import io.reactivex.disposables.Disposable;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by 康颢曦 on 2017/3/9.
 */
public class DribbbleServiceTest {
    Disposable mDisposable;
    List<ShotBean> list;
    LipperUser mLipperUser;
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public BaseRule baseRule = new BaseRule(getUserHelper());

    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();


    private UserHelper getUserHelper() {
        UserHelper userHelper;
        userHelper = Mockito.mock(UserHelper.class);
        when(userHelper.isLogin()).thenReturn(true);
        UserToken userToken= new UserToken();
        userToken.setAccess_token("a9d9a7332cc3454a651bfd3f245e6e6bc04087fcc381b4f469af31f342e9a86f");
        when(userHelper.getToken()).thenReturn(userToken);
        return userHelper;
    }




    @Test
    public void getUserInfo() throws Exception {
        mDisposable = DribbbleModelImpl.getInstance().getUserInfo()
                .onErrorResumeNext(new ConvertToApiException<>())
                .subscribe(lipperUser -> {
                    mLipperUser = lipperUser;
                    System.out.print(mLipperUser.getUsername());
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
        mDisposable =  DribbbleModelImpl.getInstance().getShot("animated", "week")
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
