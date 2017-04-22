package com.fallllllll.lipper.core.presenter;


import java.util.List;

/**
 * Created by 康颢曦 on 2017/1/17.
 */

public class PresenterLifecycleHelper {
   private List<Contract.Presenter> mPresenterList;


    public PresenterLifecycleHelper(List<Contract.Presenter> IPresenterList) {
        mPresenterList = IPresenterList;

    }

    public void onPresenterCreate(){
        if (checkList()) {
            for (Contract.Presenter presenter:mPresenterList){
                if (presenter!=null){
                    presenter.onPresenterCreate();
                }
            }
        }
    }

    public void destroyPresenter(){
        if (checkList()) {
            for (Contract.Presenter presenter:mPresenterList){
                if (presenter!=null){
                    presenter.detach();
                }
            }
        }
    }
    public void attach() {
        if (checkList()) {
            for (Contract.Presenter presenter:mPresenterList){
                if (presenter!=null){
                    presenter.attach();
                }
            }
        }
    }

    private boolean checkList(){
        if (mPresenterList != null && mPresenterList.size() > 0)return true;
        return false;
    }

}
