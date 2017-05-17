package com.fallllllll.lipper.data.databean;

/**
 * Created by fallllllll on 2017/5/11/011.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class HomeListFilterBean {
    private String time;
    private String type;
    private String sort;

    public HomeListFilterBean(String time, String type, String sort) {
        this.time = time;
        this.type = type;
        this.sort = sort;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "HomeListFilterBean{" +
                "time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
