package com.fallllllll.lipper.data.network.service;

import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.data.local.user.LipperUser;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public interface DribbbleService {

    @GET("shots")
    Flowable<List<ShotBean>> getShot(@Query("list") String list, @Query("timeframe") String timeframe);

    @GET("user")
    Flowable<LipperUser> getUserInfo();


}
