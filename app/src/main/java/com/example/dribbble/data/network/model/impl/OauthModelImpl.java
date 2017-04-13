package com.example.dribbble.data.network.model.impl;

import com.example.dribbble.core.constants.DribbbleID;
import com.example.dribbble.data.local.user.UserToken;
import com.example.dribbble.data.network.DribbbleHttpMethods;
import com.example.dribbble.data.network.OauthHttpMethods;
import com.example.dribbble.data.network.model.OauthModel;
import com.example.dribbble.data.network.service.DribbbleService;
import com.example.dribbble.data.network.service.OauthService;

import io.reactivex.Flowable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 康颢曦 on 2017/3/20.
 */

public class OauthModelImpl implements OauthModel {

    private static OauthModelImpl ourInstance;
    private OauthService mOauthService;

    private OauthModelImpl() {
        mOauthService = OauthHttpMethods.getInstance().getService();
    }

    public static OauthModelImpl getInstance() {
        if (ourInstance == null) {
            synchronized (OauthModelImpl.class) {
                if (ourInstance == null) {
                    ourInstance = new OauthModelImpl();
                }
            }
        }
        return ourInstance;
    }


    @Override
    public Flowable<UserToken> getToken(RequestBody code) {
        RequestBody client_id = RequestBody.create(MediaType.parse("multipart/form-data"), DribbbleID.CLIENT_ID);
        RequestBody client_secret = RequestBody.create(MediaType.parse("multipart/form-data"), DribbbleID.CLIENT_SECRET);
        RequestBody redirect_uri = RequestBody.create(MediaType.parse("multipart/form-data"), DribbbleID.CALLBACK_URL);
        return mOauthService.getToken(client_id, client_secret, redirect_uri, code);
    }
}
