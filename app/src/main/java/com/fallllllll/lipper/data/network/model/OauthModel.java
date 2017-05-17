package com.fallllllll.lipper.data.network.model;

import com.fallllllll.lipper.data.local.user.UserToken;

import io.reactivex.Flowable;

/**
 * Created by fallllllll on 2017/3/20.
 * GitHub :  https://github.com/348476129/Lipper
 */

public interface OauthModel {

    Flowable<UserToken> getToken( String code);

}
