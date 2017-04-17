package com.example.dribbble.data.local.user;

import com.example.dribbble.utils.RealmUtils;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by 康颢曦 on 2017/3/16.
 */

public class UserHelper {

    private Realm mRealm = Realm.getDefaultInstance();


    public LipperUser getUserData() {
        if (isLogin()) {
            return Realm.getDefaultInstance().copyFromRealm(mRealm.where(LipperUser.class)
                    .findFirst());
        } else {
            return null;
        }
    }


    public boolean saveOrUpdateUser(LipperUser lipperUser) {
        if (lipperUser == null) return false;
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(lipperUser);
        mRealm.commitTransaction();
        return true;
    }

    public boolean saveToken(UserToken userToken) {
        if (userToken == null) return false;
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(userToken);
        mRealm.commitTransaction();
        return true;

    }

    public UserToken getToken() {
        UserToken userToken;
        UserToken realmUserToken = mRealm.where(UserToken.class)
                .findFirst();
        userToken=Realm.getDefaultInstance().copyFromRealm(realmUserToken);

        return userToken;

    }

    public void logOut() {
        RealmUtils.deleteAll(UserToken.class);
        RealmUtils.deleteAll(LipperUser.class);
    }

    public boolean isLogin() {
        return getToken() != null;
    }

}
