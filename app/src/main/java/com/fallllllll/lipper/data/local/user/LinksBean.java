package com.fallllllll.lipper.data.local.user;


import java.io.Serializable;

/**
 * Created by fallllllll on 2017/3/16.
 * GitHub :  https://github.com/348476129/Lipper
 */
public class LinksBean implements Serializable{


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
