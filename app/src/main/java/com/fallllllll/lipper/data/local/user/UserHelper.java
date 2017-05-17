package com.fallllllll.lipper.data.local.user;

import com.fallllllll.lipper.data.local.datatank.DataTank;

import java.io.IOException;
/**
 * Created by fallllllll on 2017/3/16.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class UserHelper {

    private static final String KEY_USER_TOKEN = "key_userToken";
    private static final String KEY_USER_DATA = "key_userData";


    public LipperUser getUserData() throws IOException {
        if (isLogin()) {
            return DataTank.getSynchronization(KEY_USER_DATA, LipperUser.class);
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

        return DataTank.getSynchronization(KEY_USER_TOKEN, UserToken.class);

    }

    public void logOut() throws IOException {
        DataTank.deleteSynchronization(KEY_USER_TOKEN);
        DataTank.deleteSynchronization(KEY_USER_DATA);
    }

    public boolean isLogin() throws IOException {
        return getToken() != null;
    }

}
