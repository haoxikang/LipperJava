package com.fallllllll.lipper.data.local.user;

import com.fallllllll.lipper.data.local.datatank.DataTank;

import java.io.IOException;
/**
 * Created by fallllllll on 2017/3/16.
 */

public class UserHelper {

    private static final String KEY_USER_TOKEN = "key_userToken";
    private static final String KEY_USER_DATA = "key_userData";


    public LipperUser getUserData() throws IOException {
        if (isLogin()) {
            LipperUser lipperUser = DataTank.getSynchronization(KEY_USER_DATA, LipperUser.class);
            return lipperUser;
        } else {
            return null;
        }
    }


    public boolean saveOrUpdateUser(LipperUser lipperUser) throws IOException {
        if (lipperUser == null) return false;
        DataTank.putSynchronization(KEY_USER_DATA, lipperUser);
        return true;
    }

    public boolean saveToken(UserToken userToken) throws IOException {
        if (userToken == null) return false;
        DataTank.putSynchronization(KEY_USER_TOKEN, userToken);
        return true;

    }

    public UserToken getToken() throws IOException {
        UserToken userToken = DataTank.getSynchronization(KEY_USER_TOKEN, UserToken.class);

        return userToken;

    }

    public void logOut() throws IOException {
        DataTank.deleteSynchronization(KEY_USER_TOKEN);
        DataTank.deleteSynchronization(KEY_USER_DATA);
    }

    public boolean isLogin() throws IOException {
        return getToken() != null;
    }

}
