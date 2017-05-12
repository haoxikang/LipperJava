package com.fallllllll.lipper.data.local.datatank;

import com.fallllllll.lipper.BaseApplication;
import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.utils.RxSchedulersOverrideRule;
import com.google.common.reflect.TypeToken;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/5/9/009.
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = TestApplication.class)
public class DataTankTest {
    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();
    GsonAdapter gsonAdapter;
    TestBean bean;
    boolean result = false;
    int count = 0;
    File file = new File("build");

    @Test
    public void testDataTank() throws IOException {
        gsonAdapter = new GsonAdapter(((BaseApplication) RuntimeEnvironment.application).getInstance().getGson());
        DataTank.init(file.getPath(), 20480, gsonAdapter);
        put();
        contains();
        get();
        delete();
        clear();
    }

    private void put() {
        TestBean testBean = new TestBean("test");
        DataTank.put("test", testBean).subscribe(aBoolean -> {
            result = aBoolean;
        }, throwable -> {

        });
        System.out.print(result);
        assertTrue(result);

        List<TestBean> list = new ArrayList<>();
        list.add(new TestBean("t"));
        list.add(new TestBean("t"));
        list.add(new TestBean("t"));
        list.add(new TestBean("t"));
        DataTank.put("testList", list).subscribe(aBoolean -> {
            result = aBoolean;
        }, throwable -> {

        });
        System.out.print(result);
        assertTrue(result);

    }


    private void contains() {
        result = false;
        DataTank.contains("test").subscribe(aBoolean -> {
            result = aBoolean;
        }, throwable -> {

        });
        System.out.print(result);
        assertTrue(result);
        DataTank.contains("testList").subscribe(aBoolean -> {
            result = aBoolean;
        }, throwable -> {

        });
        System.out.print(result);
        assertTrue(result);

    }

    private void get() {
        count = 0;
        DataTank.get("test", TestBean.class).subscribe(testBean -> {

            bean = testBean;
        }, throwable -> {
            System.out.print(throwable.getMessage());
        });
        System.out.print(bean.getTest());
        assertNotNull(bean);

        Type resultType = new TypeToken<List<TestBean>>() {
        }.getType();
        DataTank.get("testList", TestBean.class, resultType).subscribe(testBean -> {
            count++;
        }, throwable -> {
        });
        assertEquals(count, 4);
    }

    private void delete() {
        DataTank.delete("test").subscribe(aBoolean -> {
            result = aBoolean;
        });
        assertTrue(result);
        DataTank.contains("test").subscribe(aBoolean -> {
            result = aBoolean;
        }, throwable -> {

        });
        assertFalse(result);

    }

    private void clear() {
        DataTank.clear().subscribe(aBoolean -> {
            result = aBoolean;
        });
        assertTrue(result);
        DataTank.contains("test").subscribe(aBoolean -> {
            result = aBoolean;
        }, throwable -> {

        });
        assertFalse(result);
        DataTank.contains("testList").subscribe(aBoolean -> {
            result = aBoolean;
        }, throwable -> {

        });
        assertFalse(result);
    }
}