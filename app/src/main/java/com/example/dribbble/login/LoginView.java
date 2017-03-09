package com.example.dribbble.login;


import com.example.dribbble.core.presenter.Contract;
import com.example.dribbble.data.databean.ShotBean;

/**
 * Created by qqq34 on 2017/3/8.
 */

public interface LoginView extends Contract.BaseView{
    void onDataFetch(ShotBean test);
}


