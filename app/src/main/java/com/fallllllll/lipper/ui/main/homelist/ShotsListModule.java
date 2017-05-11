package com.fallllllll.lipper.ui.main.homelist;

import com.fallllllll.lipper.data.network.model.DribbbleModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/4/28/028.
 */

@Module
public class ShotsListModule {
    private ShotsListContract.ShotsListView shotsListView;

    public ShotsListModule(ShotsListContract.ShotsListView shotsListView) {
        this.shotsListView = shotsListView;
    }
    @Provides
    ShotsListContract.ShotsListPresenter provideShotsListPresenter(DribbbleModel dribbbleModel){
        return new ShotsListPresenterImpl(dribbbleModel,shotsListView);
    }
}
