package com.example.dribbble.data;

import com.example.dribbble.core.constants.DribbbleID;
import com.example.dribbble.core.rxjava.exceptionalhandling.ApiException;
import com.example.dribbble.core.rxjava.exceptionalhandling.HttpResponseFunc;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.data.network.model.impl.DribbbleModelImpl;
import com.example.dribbble.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

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

        mDisposable = mDribbbleModel.getShot("animated", "week", "")
                .onErrorResumeNext(new HttpResponseFunc<>())
                .subscribe(testList -> {
                    System.out.print(testList.get(0).getTitle());
                }, throwable -> {
                    if (throwable instanceof ApiException) {
                        ApiException a = (ApiException) throwable;
                        System.out.print(a.message);
                    }
                });
//    assertNotNull(list);
    }

    @After
    public void testFinished() {
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }

    }
}
