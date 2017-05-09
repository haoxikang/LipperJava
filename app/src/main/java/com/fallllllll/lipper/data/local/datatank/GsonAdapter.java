package com.fallllllll.lipper.data.local.datatank;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/5/9/009.
 */

public class GsonAdapter implements JsonAdapter {
    private Gson gson;

    public GsonAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String toJson(Object object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json,classOfT);
    }

    @Override
    public <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json,typeOfT);
    }
}
