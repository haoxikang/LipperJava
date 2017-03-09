package com.example.dribbble.data.network;

import com.example.dribbble.data.databean.ShotBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qqq34 on 2017/3/8.
 */

public interface DribbbleService {
    @GET("shots")
    Flowable<List<ShotBean>> getShot(@Query("list")String list, @Query("timeframe")String timeframe, @Query("access_token")String access_token);
}
