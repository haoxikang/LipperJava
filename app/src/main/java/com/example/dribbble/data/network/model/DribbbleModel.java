package com.example.dribbble.data.network.model;

import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.user.LipperUser;
import com.example.dribbble.user.UserToken;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by qqq34 on 2017/3/8.
 */

public interface DribbbleModel {
    Flowable<List<ShotBean>> getShot(String list, String timeframe);

    Flowable<LipperUser> getUserInfo();


    Flowable<UserToken> getToken(RequestBody code);
}
