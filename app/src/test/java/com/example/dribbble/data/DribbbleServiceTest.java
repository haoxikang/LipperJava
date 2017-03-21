package com.example.dribbble.data;

import com.example.dribbble.core.BaseRealmTest;
import com.example.dribbble.core.rxjava.exceptionalhandling.ApiException;
import com.example.dribbble.core.rxjava.exceptionalhandling.ConvertToApiException;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.local.user.LipperUser;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.core.classloader.annotations.PowerMockIgnore;

import java.util.List;

import io.reactivex.disposables.Disposable;

import static org.junit.Assert.assertNotNull;

/**
 * Created by qqq34 on 2017/3/9.
 */
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*", "retrofit2.*", "okhttp3.*"
        , "com.example.dribbble.data.network.service.*", "io.reactivex.*"
        , "com.example.dribbble.data.local.user.LipperUser",
        "com.example.dribbble.data.local.user.LinksBean"
        , "com.example.dribbble.data.local.databean.ShotBean"})
public class DribbbleServiceTest extends BaseRealmTest {
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
    public void setup() throws Exception {
        super.setup();
        mDribbbleModel = DribbbleModelImpl.getInstance();
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
