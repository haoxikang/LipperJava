package com.fallllllll.lipper.data.databean;

/**
 * Created by Administrator on 2017/4/28/028.
 */
public class ImagesBean {
    /**
     * hidpi : https://d13yacurqjgara.cloudfront.net/users/244516/screenshots/3332372/running_on_empty_eran_mendel_dribbble_gif.gif
     * normal : https://d13yacurqjgara.cloudfront.net/users/244516/screenshots/3332372/running_on_empty_eran_mendel_dribbble_gif_1x.gif
     * teaser : https://d13yacurqjgara.cloudfront.net/users/244516/screenshots/3332372/running_on_empty_eran_mendel_dribbble_gif_teaser.gif
     */

    private String hidpi;
    private String normal;
    private String teaser;

    public String getHidpi() {
        return hidpi;
    }

    public void setHidpi(String hidpi) {
        this.hidpi = hidpi;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }
}
