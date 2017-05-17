package com.fallllllll.lipper.data.local.datatank;

import java.lang.reflect.Type;

/**
 * Created by fallllllll on 2017/5/8.
 * GitHub :  https://github.com/348476129/Lipper
 */

public interface JsonAdapter {
    String toJson(Object object);

    <T> T fromJson(String json, Class<T> classOfT);

    <T> T fromJson(String json, Type typeOfT);


}
