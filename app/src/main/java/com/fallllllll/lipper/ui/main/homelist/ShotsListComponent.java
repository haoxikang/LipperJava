package com.fallllllll.lipper.ui.main.homelist;

import com.fallllllll.lipper.dagger.AppComponent;

import dagger.Component;

/**
 * Created by fallllllll on 2017/4/28/028.
 * GitHub :  https://github.com/348476129/Lipper
 */

@Component(dependencies = AppComponent.class,modules = {ShotsListModule.class})
public interface ShotsListComponent {
    void inject(ShotsListFragment shotsListFragment);
}
