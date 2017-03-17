package com.example.dribbble.data.network.model;

import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.local.user.LipperUser;
import com.example.dribbble.data.local.user.UserToken;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

/**
 * Created by qqq34 on 2017/3/8.
 */

public interface DribbbleModel {
    Flowable<List<ShotBean>> getShot(String token,String list, String timeframe);

    Flowable<LipperUser> getUserInfo();


    Flowable<UserToken> getToken(RequestBody code);
}
