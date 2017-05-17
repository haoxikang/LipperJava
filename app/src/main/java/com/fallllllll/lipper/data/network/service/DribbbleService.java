package com.fallllllll.lipper.data.network.service;

import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.data.local.user.LipperUser;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fallllllll on 2017/3/8.
 * GitHub :  https://github.com/348476129/Lipper
 */

public interface DribbbleService {

    @GET("shots")
    Flowable<List<ShotBean>> getShot(@Query("list") String list, @Query("timeframe") String timeframe,@Query("sort")String sort,@Query("page")String page,@Query("per_page")String perPage);

    @GET("user")
    Flowable<LipperUser> getUserInfo();


}
