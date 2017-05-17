package com.fallllllll.lipper.core.presenter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by fallllllll on 2017/1/17.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class PresenterLifecycleHelper {
    private List<Contract.Presenter> mPresenterList;

    public void addPresenter(Contract.Presenter presenter) {
        mPresenterList.add(presenter);
        if (presenter != null) {
            presenter.attach();
        }
    }

    public PresenterLifecycleHelper() {
        mPresenterList = new ArrayList<>();

    }

    public void onPresenterCreate() {
        if (checkList()) {
            for (Contract.Presenter presenter : mPresenterList) {
                if (presenter != null) {
                    presenter.onPresenterCreate();
                }
            }
        }
    }

    public void destroyPresenter() {
        if (checkList()) {
            for (Contract.Presenter presenter : mPresenterList) {
                if (presenter != null) {
                    presenter.detach();
                }
            }
        }
    }

    private boolean checkList() {
        return mPresenterList != null && mPresenterList.size() > 0;
    }

}
