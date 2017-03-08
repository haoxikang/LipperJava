package com.example.dribbble.data.network.model;

import com.example.dribbble.data.network.Test;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by qqq34 on 2017/3/8.
 */

public interface DribbbleModel {
    Flowable<List<Test>> getShot(String list, String timeframe, String access_token);
}
