package com.fallllllll.lipper.core.presenter;


import com.fallllllll.lipper.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 康颢曦 on 2017/1/17.
 */

public class PresenterLifecycleHelper {
   private List<Contract.Presenter> mPresenterList;

   public void addPresenter(Contract.Presenter presenter){
       mPresenterList.add(presenter);
   }

    public PresenterLifecycleHelper() {
        mPresenterList = new ArrayList<>();

    }

    public void onPresenterCreate(){
        if (checkList()) {
            for (Contract.Presenter presenter:mPresenterList){
                if (presenter!=null){
                    presenter.attach();
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

    private boolean checkList(){
        if (mPresenterList != null && mPresenterList.size() > 0)return true;
        return false;
    }

}
