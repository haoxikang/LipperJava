package com.fallllllll.lipper.data.network.model.impl;

import com.fallllllll.lipper.core.constants.DribbbleID;
import com.fallllllll.lipper.data.local.user.UserToken;
import com.fallllllll.lipper.data.network.OauthHttpMethods;
import com.fallllllll.lipper.data.network.model.OauthModel;
import com.fallllllll.lipper.data.network.service.OauthService;

import io.reactivex.Flowable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by fallllllll on 2017/3/20.
 * GitHub :  https://github.com/348476129/Lipper
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
