package com.fallllllll.dribbble.data.network.model.impl;

import com.fallllllll.dribbble.core.constants.DribbbleID;
import com.fallllllll.dribbble.data.local.user.UserToken;
import com.fallllllll.dribbble.data.network.OauthHttpMethods;
import com.fallllllll.dribbble.data.network.model.OauthModel;
import com.fallllllll.dribbble.data.network.service.OauthService;

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
    public Flowable<UserToken> getToken(String code) {
        RequestBody client_id = RequestBody.create(MediaType.parse("multipart/form-data"), DribbbleID.CLIENT_ID);
        RequestBody client_secret = RequestBody.create(MediaType.parse("multipart/form-data"), DribbbleID.CLIENT_SECRET);
        RequestBody redirect_uri = RequestBody.create(MediaType.parse("multipart/form-data"), DribbbleID.CALLBACK_URL);
        RequestBody  oauthCode= RequestBody.create(MediaType.parse("multipart/form-data"), code);

        return mOauthService.getToken(client_id, client_secret, redirect_uri, oauthCode);
    }
}
