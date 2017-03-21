package com.example.dribbble.login;

import android.content.Context;

import com.example.dribbble.BuildConfig;
import com.example.dribbble.DribbbleApplication;
import com.example.dribbble.core.BaseRealmTest;
import com.example.dribbble.core.MyRobolectricTestRunner;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.local.user.UserToken;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
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


public class PowerTest extends BaseRealmTest {


    DribbbleModel mDribbbleModel;


    @Before
    public void setup() throws Exception {
        super.setup();
        mDribbbleModel = DribbbleModelImpl.getInstance();


    }

    @Test
    public void test() {
        Assert.assertNotNull(new UserHelper().getToken());
    }

}
