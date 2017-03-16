package com.example.dribbble.user;

import io.realm.Realm;

/**
 * Created by qqq34 on 2017/3/16.
 */

public class UserUtils {

    public static UserToken saveToken(UserToken userToken) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        UserToken realmUserToken = realm.copyFromRealm(userToken);
        realm.commitTransaction();
        return realmUserToken;
    }

    public static UserToken getToken() {
        return Realm.getDefaultInstance().where(UserToken.class)
                .equalTo("id", "token")
                .findFirst();

    }

    public static boolean isLogin() {
        UserToken userToken = Realm.getDefaultInstance().where(UserToken.class)
                .equalTo("id", "token")
                .findFirst();
        return userToken != null;
    }
}
