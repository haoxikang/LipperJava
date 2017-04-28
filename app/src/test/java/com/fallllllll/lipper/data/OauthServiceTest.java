package com.fallllllll.lipper.data;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.data.local.user.UserToken;
import com.fallllllll.lipper.utils.BaseRule;
import com.fallllllll.lipper.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.annotation.Config;

import io.reactivex.disposables.Disposable;

import static org.junit.Assert.assertNotNull;

/**
 * Created by fallllllll on 2017/3/20.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApplication.class)
public class OauthServiceTest {

    UserToken mUserToken;
    Disposable mDisposable;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Rule
    public BaseRule baseRule = new BaseRule(false);


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