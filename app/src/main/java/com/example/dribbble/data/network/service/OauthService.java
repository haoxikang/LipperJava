package com.example.dribbble.data.network.service;

import com.example.dribbble.data.local.user.UserToken;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by 康颢曦 on 2017/3/20.
 */

public interface OauthService  {

    @Multipart
    @POST("token")
    Flowable<UserToken> getToken(@Part("client_id") RequestBody client_id,@Part("client_secret") RequestBody client_secret,@Part("redirect_uri") RequestBody redirect_uri,@Part("code") RequestBody code);

}
