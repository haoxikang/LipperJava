package com.fallllllll.lipper.data.network.model;

import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.data.local.user.LipperUser;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public interface DribbbleModel {
    Flowable<List<ShotBean>> getShot(String list, String timeframe);

    Flowable<LipperUser> getUserInfo();

}
