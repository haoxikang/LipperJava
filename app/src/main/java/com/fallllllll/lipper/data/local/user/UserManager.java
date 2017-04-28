package com.fallllllll.lipper.data.local.user;

import com.fallllllll.lipper.core.exception.HaveNotInitException;

/**
 * Created by fallllllll on 2017/4/13/013.
 * 为了避免重复查询，使用一个单例来管理用户信息
 */

public enum UserManager {
    INSTANCE();

    private boolean isInit = false;

    private LipperUser lipperUser = null;
    private UserHelper userHelper = null;
    private UserToken userToken = null;

    private boolean isLogin = false;


    public void init() {
        if (!isInit) {
            userHelper = new UserHelper();
            lipperUser = userHelper.getUserData();
            userToken = userHelper.getToken();
            isLogin = userHelper.isLogin();
            isInit = true;
        }
    }

    public void init(UserHelper userHelper) {
        if (!isInit) {
            this.userHelper = userHelper;
            lipperUser = userHelper.getUserData();
            userToken = userHelper.getToken();
            isLogin = userHelper.isLogin();
            isInit = true;
        }
    }

    public boolean isLogin() {
        checkInitStatus();
        return isLogin;
    }

    public LipperUser getUser() {
        checkInitStatus();
        return lipperUser;
    }

    public UserToken getUserToken() {
        checkInitStatus();
        return userToken;
    }

    public boolean updateUser(LipperUser lipperUser) {
        checkInitStatus();
        if (userHelper.saveOrUpdateUser(lipperUser)) {
            this.lipperUser = lipperUser;
            isLogin = true;
            return true;

        } else return false;
    }

    public boolean updateToken(UserToken userToken) {
        checkInitStatus();
        if (userHelper.saveToken(userToken)) {
            this.userToken = userToken;

            return true;
        } else return false;
    }

    public void logOut() {
        checkInitStatus();
        if (isLogin) {
            userHelper.logOut();
            isLogin = false;
        }
    }

    private void checkInitStatus() {
        if (!isInit) {
            try {
                throw new HaveNotInitException();
            } catch (HaveNotInitException e) {
                e.printStackTrace();
            }
        }
    }
}
