package com.example.dribbble.login;

import com.example.dribbble.core.presenter.Contract;
import com.example.dribbble.data.databean.ShotBean;

/**
 * Created by Administrator on 2017/4/14/014.
 */

public interface LoginContract {
    interface  LoginView extends Contract.BaseView{

        void onDataFetch(ShotBean test);
        void GoWebActivityForResult();
    }
    interface LoginPresenter extends  Contract.Presenter{
        void getUserData(String code);
        void onLoginClick();
    }
}
