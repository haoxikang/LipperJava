package com.example.dribbble.core;

import android.content.Context;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.data.local.user.UserToken;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.internal.RealmCore;
import io.realm.log.RealmLog;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Created by qqq34 on 2017/3/21.
 */

@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = DribbbleApplication.class)
@SuppressStaticInitializationFor("io.realm.internal.Util")
@PrepareForTest({Realm.class, RealmConfiguration.class, RealmQuery.class, RealmResults.class, RealmCore.class, RealmLog.class})
public class BaseRealmTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();
    @Before
    public void setup() throws Exception {
        mockStatic(RealmCore.class);
        mockStatic(RealmLog.class);
        mockStatic(Realm.class);
        mockStatic(RealmConfiguration.class);
        Realm.init(RuntimeEnvironment.application);

        final Realm mockRealm = mock(Realm.class);
        final RealmConfiguration mockRealmConfig = mock(RealmConfiguration.class);

        doNothing().when(RealmCore.class);
        RealmCore.loadLibrary(any(Context.class));


            whenNew(RealmConfiguration.class).withAnyArguments().thenReturn(mockRealmConfig);

        when(Realm.getDefaultInstance()).thenReturn(mockRealm);

        UserToken userToken = new UserToken();
        userToken.setAccess_token("a9d9a7332cc3454a651bfd3f245e6e6bc04087fcc381b4f469af31f342e9a86f");


        List<UserToken> userTokenList = Arrays.asList(userToken);
        RealmQuery<UserToken> userTokenQuery = mockRealmQuery();

        when(userTokenQuery.findFirst()).thenReturn(userTokenList.get(0));
        when(userTokenQuery.equalTo("id", "token")).thenReturn(userTokenQuery);
        when(mockRealm.where(UserToken.class)).thenReturn(userTokenQuery);
        when(mockRealm.where(UserToken.class).findFirst()).thenReturn(userToken);
    }
    @SuppressWarnings("unchecked")
    private <T extends RealmObject> RealmQuery<T> mockRealmQuery() {
        return mock(RealmQuery.class);
    }

    @SuppressWarnings("unchecked")
    private <T extends RealmObject> RealmResults<T> mockRealmResults() {
        return mock(RealmResults.class);
    }
}
