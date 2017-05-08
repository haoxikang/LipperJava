package com.fallllllll.lipper.data.local.datatank;

import java.lang.reflect.Type;

/**
 * Created by 康颢曦 on 2017/5/8.
 */

public interface JsonAdapter {
    String toJson(Object object);

    <T> T fromJson(String json, Class<T> classOfT);

    <T> T fromJson(String json, Type typeOfT);


}
