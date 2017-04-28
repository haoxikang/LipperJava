package com.fallllllll.lipper.data.local.user;

import com.fallllllll.lipper.utils.RealmUtils;

import io.realm.Realm;

/**
 * Created by fallllllll on 2017/3/16.
 */

public class UserHelper {

    private Realm mRealm = Realm.getDefaultInstance();


    public LipperUser getUserData() {
        if (isLogin()) {
            LipperUser lipperUser = mRealm.where(LipperUser.class)
                    .findFirst();
            if (lipperUser==null)return null;
            return Realm.getDefaultInstance().copyFromRealm(lipperUser);
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
        UserToken userToken=null;
        UserToken realmUserToken = mRealm.where(UserToken.class)
                .findFirst();
        if (realmUserToken!=null){
            userToken=Realm.getDefaultInstance().copyFromRealm(realmUserToken);
        }


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
