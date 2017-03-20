package com.example.dribbble.data.local.user;

import io.realm.Realm;

/**
 * Created by qqq34 on 2017/3/16.
 */

public class UserHelper {

private Realm mRealm = Realm.getDefaultInstance();


    public UserToken saveToken(UserToken userToken) {
        mRealm.beginTransaction();
        UserToken realmUserToken = mRealm.copyFromRealm(userToken);
        mRealm.commitTransaction();
        return realmUserToken;
    }

    public UserToken getToken() {
        return mRealm.where(UserToken.class)
                .equalTo("id", "token")
                .findFirst();

    }

    public boolean isLogin() {
        UserToken userToken =mRealm.where(UserToken.class)
                .equalTo("id", "token")
                .findFirst();
        return userToken != null;
    }
}
