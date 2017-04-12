package com.example.dribbble.utils;

import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.network.model.DribbbleModel;

import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * Created by qqq34 on 2017/3/9.
 */

public class TestUtils {
    public static UserHelper getDefaultMockUserHelper(){
        UserHelper userHelper;
        userHelper = Mockito.mock(UserHelper.class);
        when(userHelper.isLogin()).thenReturn(false);
        return userHelper;
    }

}
