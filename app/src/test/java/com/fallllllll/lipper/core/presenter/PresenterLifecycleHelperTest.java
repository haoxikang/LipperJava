package com.fallllllll.lipper.core.presenter;

import com.fallllllll.lipper.ui.login.LoginContract;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by Administrator on 2017/4/27/027.
 */
public class PresenterLifecycleHelperTest {

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Mock
    LoginContract.LoginPresenter presenter;
    @Test
    public void textPresenterLifecycleHelperTest(){
        PresenterLifecycleHelper presenterLifecycleHelper = new PresenterLifecycleHelper();
        presenterLifecycleHelper.addPresenter(presenter);
        presenterLifecycleHelper.onPresenterCreate();
        presenterLifecycleHelper.destroyPresenter();
        verify(presenter).attach();
        verify(presenter).onPresenterCreate();
        verify(presenter).detach();
    }

}