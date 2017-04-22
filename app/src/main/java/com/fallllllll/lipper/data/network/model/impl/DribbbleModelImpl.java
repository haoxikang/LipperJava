package com.fallllllll.lipper.data.network.model.impl;

import com.fallllllll.lipper.data.network.DribbbleHttpMethods;
import com.fallllllll.lipper.data.network.service.DribbbleService;
import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.data.network.model.DribbbleModel;
import com.fallllllll.lipper.data.local.user.LipperUser;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public class DribbbleModelImpl implements DribbbleModel {


    private static DribbbleModelImpl ourInstance;
    private DribbbleService mDribbbleService;

    private DribbbleModelImpl() {
        mDribbbleService = DribbbleHttpMethods.getInstance().getService();
    }

    public static DribbbleModelImpl getInstance() {
        if (ourInstance == null) {
            synchronized (DribbbleModelImpl.class) {
                if (ourInstance == null) {
                    ourInstance = new DribbbleModelImpl();
                }
            }
        }
        return ourInstance;
    }


    @Override
    public Flowable<List<ShotBean>> getShot( String list, String timeframe) {
        return mDribbbleService.getShot(list, timeframe);
    }

    @Override
    public Flowable<LipperUser> getUserInfo() {
        return mDribbbleService.getUserInfo();
    }

}
