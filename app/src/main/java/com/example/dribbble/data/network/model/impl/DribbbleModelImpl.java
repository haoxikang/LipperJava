package com.example.dribbble.data.network.model.impl;

import com.example.dribbble.data.network.DribbbleService;
import com.example.dribbble.data.network.HttpMethods;
import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.example.dribbble.user.LipperUser;
import com.example.dribbble.user.UserToken;
import com.example.dribbble.user.UserUtils;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

/**
 * Created by qqq34 on 2017/3/8.
 */

public class DribbbleModelImpl implements DribbbleModel {


    private static DribbbleModelImpl ourInstance;
    private DribbbleService mDribbbleService = HttpMethods.getInstance().getDribbbleService();

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
    public Flowable<List<ShotBean>> getShot(String list, String timeframe) {
        return mDribbbleService.getShot(list, timeframe);
    }

    @Override
    public Flowable<LipperUser> getUserInfo() {
        return mDribbbleService.getUserInfo();
    }

    @Override
    public Flowable<UserToken> getToken(RequestBody code) {
        return mDribbbleService.getToken(code);
    }
}
