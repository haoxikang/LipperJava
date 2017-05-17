package com.fallllllll.lipper.data.network.service;

import com.fallllllll.lipper.data.local.user.UserToken;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by fallllllll on 2017/3/20.
 * GitHub :  https://github.com/348476129/Lipper
 */

public interface OauthService  {

    @Multipart
    @POST("token")
    Flowable<UserToken> getToken(@Part("client_id") RequestBody client_id,@Part("client_secret") RequestBody client_secret,@Part("redirect_uri") RequestBody redirect_uri,@Part("code") RequestBody code);

}
