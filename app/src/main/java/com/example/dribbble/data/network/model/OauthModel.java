package com.example.dribbble.data.network.model;

import com.example.dribbble.data.local.user.UserToken;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Part;

/**
 * Created by 康颢曦 on 2017/3/20.
 */

public interface OauthModel {

    Flowable<UserToken> getToken( String code);

}
