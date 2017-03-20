package com.example.dribbble.data.network.service;

import com.example.dribbble.data.databean.ShotBean;
import com.example.dribbble.data.local.user.LipperUser;
import com.example.dribbble.data.local.user.UserToken;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by qqq34 on 2017/3/8.
 */

public interface DribbbleService {

    @GET("shots")
    Flowable<List<ShotBean>> getShot(@Query("list") String list, @Query("timeframe") String timeframe);

    @GET("user")
    Flowable<LipperUser> getUserInfo();


}
