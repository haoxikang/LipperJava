package com.example.dribbble.utils;

import com.example.dribbble.data.local.user.LipperUser;
import com.example.dribbble.data.local.user.UserHelper;
import com.example.dribbble.data.local.user.UserToken;
import com.example.dribbble.data.network.model.DribbbleModel;
import com.google.gson.Gson;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

/**
 * Created by 康颢曦 on 2017/3/9.
 */

public class TestUtils {
    public static UserHelper getDefaultMockUserHelper(){
        UserHelper userHelper;
        userHelper = Mockito.mock(UserHelper.class);
        when(userHelper.isLogin()).thenReturn(false);
        when(userHelper.getUserData()).thenReturn(null);
        when(userHelper.saveOrUpdateUser(any(LipperUser.class))).thenReturn(true);
        when(userHelper.saveToken(any(UserToken.class))).thenReturn(true);
        when(userHelper.getToken()).thenReturn(null);
        return userHelper;
    }
    public static UserHelper getLoginMockUserHelper(){
        LipperUser lipperUser = new Gson().fromJson("{\"UserID\":\"user\",\"avatar_url\":\"https://cdn.dribbble.com/assets/avatar-default-aa2eab7684294781f93bc99ad394a0eb3249c5768c21390163c9f55ea8ef83a4.gif\",\"bio\":\"\",\"buckets_count\":0,\"buckets_url\":\"https://api.dribbble.com/v1/users/1632887/buckets\",\"can_upload_shot\":false,\"comments_received_count\":0,\"created_at\":\"2017-03-07T08:05:49Z\",\"followers_count\":0,\"followers_url\":\"https://api.dribbble.com/v1/users/1632887/followers\",\"following_url\":\"https://api.dribbble.com/v1/users/1632887/following\",\"followings_count\":0,\"html_url\":\"https://dribbble.com/fallllllll\",\"id\":1632887,\"likes_count\":0,\"likes_received_count\":0,\"likes_url\":\"https://api.dribbble.com/v1/users/1632887/likes\",\"links\":{},\"name\":\"KangHX\",\"pro\":false,\"projects_count\":0,\"rebounds_received_count\":0,\"shots_count\":0,\"shots_url\":\"https://api.dribbble.com/v1/users/1632887/shots\",\"teams_count\":0,\"teams_url\":\"https://api.dribbble.com/v1/users/1632887/teams\",\"type\":\"User\",\"updated_at\":\"2017-03-07T08:06:14Z\",\"username\":\"fallllllll\"}\n",LipperUser.class);
        UserToken userToken = new Gson().fromJson("{\"access_token\":\"a9d9a7332cc3454a651bfd3f245e6e6bc04087fcc381b4f469af31f342e9a86f\",\"created_at\":1489635085,\"id\":\"token\",\"scope\":\"public write comment upload\",\"token_type\":\"bearer\"}",UserToken.class);

        UserHelper userHelper;
        userHelper = Mockito.mock(UserHelper.class);
        when(userHelper.isLogin()).thenReturn(true);
        when(userHelper.getUserData()).thenReturn(lipperUser);
        when(userHelper.saveOrUpdateUser(any(LipperUser.class))).thenReturn(true);
        when(userHelper.saveToken(any(UserToken.class))).thenReturn(true);
        when(userHelper.getToken()).thenReturn(userToken);
        return userHelper;
    }

}
