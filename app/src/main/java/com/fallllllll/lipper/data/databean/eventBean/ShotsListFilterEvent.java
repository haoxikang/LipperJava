package com.fallllllll.lipper.data.databean.eventBean;

/**
 * Created by Administrator on 2017/5/10/010.
 */

public class ShotsListFilterEvent {
    private final String time;
    private final String sort;
    private final String type;

    public ShotsListFilterEvent(String time, String sort, String type) {
        this.time = time;
        this.sort = sort;
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public String getSort() {
        return sort;
    }

    public String getType() {
        return type;
    }
}
