package com.fallllllll.lipper.data.local.user;

import io.realm.RealmObject;

/**
 * Created by fallllllll on 2017/3/16.
 */
public class LinksBean extends RealmObject {


    private String web;
    private String twitter;

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}