package com.example.dribbble.core.presenter;


import java.util.List;

/**
 * Created by qqq34 on 2017/1/17.
 */

public class PresenterLifecycleHelper {
   private List<Contract.Presenter> mPresenterList;


    public PresenterLifecycleHelper(List<Contract.Presenter> IPresenterList) {
        mPresenterList = IPresenterList;

    }

    public void onPresenterCreate(){
        if (checkList()) {
            mPresenterList.stream().filter(presenter -> presenter != null).forEach(Contract.Presenter::onPresenterCreate);
        }
    }

    public void destroyPresenter(){
        if (checkList()) {
            mPresenterList.stream().filter(presenter -> presenter != null).forEach(Contract.Presenter::detach);
        }
    }
    public void attach() {
        if (checkList()) {
            mPresenterList.stream().filter(presenter -> presenter != null).forEach(Contract.Presenter::attach);
        }
    }

    private boolean checkList(){
        if (mPresenterList != null && mPresenterList.size() > 0)return true;
        return false;
    }

}
