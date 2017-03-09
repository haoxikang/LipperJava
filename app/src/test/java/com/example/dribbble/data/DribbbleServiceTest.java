package com.example.dribbble.data;

import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertNotNull;

/**
 * Created by qqq34 on 2017/3/9.
 */

public class DribbbleServiceTest {
    DribbbleModel mDribbbleModel;
    Disposable mDisposable;
    List<ShotBean> list;
    @Rule
    public RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Before
    public void setup() {
        mDribbbleModel = DribbbleModelImpl.getInstance();
    }

    @Test
    public void testShotApi() {

        mDisposable = mDribbbleModel.getShot("animated", "week", "a83a642ca0a4a1017aa9645ca344b8ea94f31aa838a5e22ea1ac232b3a4d4a9a")
                .subscribe(testList -> {
                    list = testList;
                    System.out.print("" + testList.size());
                }, throwable -> {
                    System.out.print(throwable.getMessage());
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
