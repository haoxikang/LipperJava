package com.fallllllll.dribbble.data.network.model;

import com.fallllllll.dribbble.data.local.user.UserToken;

import io.reactivex.Flowable;

/**
 * Created by 康颢曦 on 2017/3/20.
 */

public interface OauthModel {

    Flowable<UserToken> getToken( String code);

}
