package com.fallllllll.lipper.ui.login;

import com.fallllllll.lipper.core.presenter.Contract;
import com.fallllllll.lipper.data.databean.ShotBean;

/**
 * Created by Administrator on 2017/4/14/014.
 */

public interface LoginContract {
    interface  LoginView extends Contract.BaseView{

        void onDataFetch(ShotBean test);
        void goWebActivityForResult();

        void setButtonEnable(boolean isEnable);

        void goMainActivity();

        void finishActivity();
    }
    interface LoginPresenter extends  Contract.Presenter{
        void getUserData(String code);
        void onLoginClick();
    }
}
