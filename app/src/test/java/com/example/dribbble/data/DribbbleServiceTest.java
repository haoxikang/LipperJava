package com.example.dribbble.data;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.core.rxjava.exceptionalhandling.ApiException;
import com.example.dribbble.core.rxjava.exceptionalhandling.ConvertToApiException;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.data.local.user.UserToken;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.annotation.Config;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.realm.Realm;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static org.junit.Assert.assertNotNull;

/**
 * Created by qqq34 on 2017/3/9.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = DribbbleApplication.class)
public class DribbbleServiceTest {
    DribbbleModel mDribbbleModel;
    Disposable mDisposable;
    List<ShotBean> list;
    UserToken mUserToken;
    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

//    @Mock
//    Realm mRealm;
    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();


    @BeforeClass
    public static void setupClass() {
    }

    @Before
    public void setup() {
        mDribbbleModel = DribbbleModelImpl.getInstance();
    }

    @Test
    public void getUserInfo() throws Exception {
        mDisposable = mDribbbleModel.getToken(RequestBody.create(
                MediaType.parse("multipart/form-data"), "d97f6ea52fd48f897605587e4a9296f55634228ae8c92a5b6a33007eef858b75"))
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

    @Test
    public void getToken() throws Exception {

    }

    @Test
    public void testShotApi() {
        mDisposable = mDribbbleModel.getShot("Bearer a9d9a7332cc3454a651bfd3f245e6e6bc04087fcc381b4f469af31f342e9a86f","animated", "week")
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
