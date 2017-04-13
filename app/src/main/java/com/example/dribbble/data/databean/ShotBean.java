package com.example.dribbble.data.databean;

import java.util.List;

/**
 * Created by 康颢曦 on 2017/3/8.
 */

public class ShotBean {


    /**
     * id : 3332372
     * title : Running On Empty
     * description : <p>(Watch x2) My submission for <a href="http://www.projectexhibita.com/" rel="nofollow noreferrer">Exhibit .A</a> - an online gallery platform. Glad to be among very talented artists.
     <br />See the video with sound <a href="https://vimeo.com/206365849" rel="nofollow noreferrer">HERE</a></p>

     <p>Follow me on:
     <br /><a href="https://www.facebook.com/Eran-Mendel-Illustrator-animator-771165769578080/?ref=aymt_homepage_panel" rel="nofollow noreferrer">Facebook</a> | <a href="https://vimeo.com/eranmendel" rel="nofollow noreferrer">Vimeo</a> | <a href="http://eranmendel.com/" rel="nofollow noreferrer">Site</a> | <a href="https://www.instagram.com/eranmendel/" rel="nofollow noreferrer">Instagram</a> </p>
     * width : 400
     * height : 300
     * images : {"hidpi":"https://d13yacurqjgara.cloudfront.net/users/244516/screenshots/3332372/running_on_empty_eran_mendel_dribbble_gif.gif","normal":"https://d13yacurqjgara.cloudfront.net/users/244516/screenshots/3332372/running_on_empty_eran_mendel_dribbble_gif_1x.gif","teaser":"https://d13yacurqjgara.cloudfront.net/users/244516/screenshots/3332372/running_on_empty_eran_mendel_dribbble_gif_teaser.gif"}
     * views_count : 9786
     * likes_count : 1025
     * comments_count : 68
     * attachments_count : 0
     * rebounds_count : 1
     * buckets_count : 98
     * created_at : 2017-03-02T07:25:05Z
     * updated_at : 2017-03-06T06:53:53Z
     * html_url : https://dribbble.com/shots/3332372-Running-On-Empty
     * attachments_url : https://api.dribbble.com/v1/shots/3332372/attachments
     * buckets_url : https://api.dribbble.com/v1/shots/3332372/buckets
     * comments_url : https://api.dribbble.com/v1/shots/3332372/comments
     * likes_url : https://api.dribbble.com/v1/shots/3332372/likes
     * projects_url : https://api.dribbble.com/v1/shots/3332372/projects
     * rebounds_url : https://api.dribbble.com/v1/shots/3332372/rebounds
     * animated : true
     * tags : ["bicycle","bike","character","gif","loop","running","sport","swim","tv"]
     * user : {"id":244516,"name":"Eran Mendel","username":"eranmendel","html_url":"https://dribbble.com/eranmendel","avatar_url":"https://d13yacurqjgara.cloudfront.net/users/244516/avatars/normal/profile_photo.jpg?1373124977","bio":"Animation director and designer\nContact me about new projects at : eranmendel@gmail.com\n <a href=\"http://www.eranmendel.com/\" rel=\"nofollow noreferrer\">eranmendel.com<\/a>","location":"Israel","links":{"web":"http://www.eranmendel.com/"},"buckets_count":4,"comments_received_count":1617,"followers_count":7859,"followings_count":271,"likes_count":767,"likes_received_count":30170,"projects_count":2,"rebounds_received_count":43,"shots_count":124,"teams_count":0,"can_upload_shot":true,"type":"Player","pro":true,"buckets_url":"https://api.dribbble.com/v1/users/244516/buckets","followers_url":"https://api.dribbble.com/v1/users/244516/followers","following_url":"https://api.dribbble.com/v1/users/244516/following","likes_url":"https://api.dribbble.com/v1/users/244516/likes","projects_url":"https://api.dribbble.com/v1/users/244516/projects","shots_url":"https://api.dribbble.com/v1/users/244516/shots","teams_url":"https://api.dribbble.com/v1/users/244516/teams","created_at":"2012-11-29T21:42:50Z","updated_at":"2017-03-08T02:00:49Z"}
     * team : null
     * rebound_source_url : https://api.dribbble.com/v1/shots/3303596
     */

    private int id;
    private String title;
    private String description;
    private int width;
    private int height;
    private ImagesBean images;
    private int views_count;
    private int likes_count;
    private int comments_count;
    private int attachments_count;
    private int rebounds_count;
    private int buckets_count;
    private String created_at;
    private String updated_at;
    private String html_url;
    private String attachments_url;
    private String buckets_url;
    private String comments_url;
    private String likes_url;
    private String projects_url;
    private String rebounds_url;
    private boolean animated;
    private UserBean user;
    private Object team;
    private String rebound_source_url;
    private List<String> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getAttachments_count() {
        return attachments_count;
    }

    public void setAttachments_count(int attachments_count) {
        this.attachments_count = attachments_count;
    }

    public int getRebounds_count() {
        return rebounds_count;
    }

    public void setRebounds_count(int rebounds_count) {
        this.rebounds_count = rebounds_count;
    }

    public int getBuckets_count() {
        return buckets_count;
    }

    public void setBuckets_count(int buckets_count) {
        this.buckets_count = buckets_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getAttachments_url() {
        return attachments_url;
    }

    public void setAttachments_url(String attachments_url) {
        this.attachments_url = attachments_url;
    }

    public String getBuckets_url() {
        return buckets_url;
    }

    public void setBuckets_url(String buckets_url) {
        this.buckets_url = buckets_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getLikes_url() {
        return likes_url;
    }

    public void setLikes_url(String likes_url) {
        this.likes_url = likes_url;
    }

    public String getProjects_url() {
        return projects_url;
    }

    public void setProjects_url(String projects_url) {
        this.projects_url = projects_url;
    }

    public String getRebounds_url() {
        return rebounds_url;
    }

    public void setRebounds_url(String rebounds_url) {
        this.rebounds_url = rebounds_url;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public Object getTeam() {
        return team;
    }

    public void setTeam(Object team) {
        this.team = team;
    }

    public String getRebound_source_url() {
        return rebound_source_url;
    }

    public void setRebound_source_url(String rebound_source_url) {
        this.rebound_source_url = rebound_source_url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static class ImagesBean {
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

    public static class UserBean {
        /**
         * id : 244516
         * name : Eran Mendel
         * username : eranmendel
         * html_url : https://dribbble.com/eranmendel
         * avatar_url : https://d13yacurqjgara.cloudfront.net/users/244516/avatars/normal/profile_photo.jpg?1373124977
         * bio : Animation director and designer
         Contact me about new projects at : eranmendel@gmail.com
         <a href="http://www.eranmendel.com/" rel="nofollow noreferrer">eranmendel.com</a>
         * location : Israel
         * links : {"web":"http://www.eranmendel.com/"}
         * buckets_count : 4
         * comments_received_count : 1617
         * followers_count : 7859
         * followings_count : 271
         * likes_count : 767
         * likes_received_count : 30170
         * projects_count : 2
         * rebounds_received_count : 43
         * shots_count : 124
         * teams_count : 0
         * can_upload_shot : true
         * type : Player
         * pro : true
         * buckets_url : https://api.dribbble.com/v1/users/244516/buckets
         * followers_url : https://api.dribbble.com/v1/users/244516/followers
         * following_url : https://api.dribbble.com/v1/users/244516/following
         * likes_url : https://api.dribbble.com/v1/users/244516/likes
         * projects_url : https://api.dribbble.com/v1/users/244516/projects
         * shots_url : https://api.dribbble.com/v1/users/244516/shots
         * teams_url : https://api.dribbble.com/v1/users/244516/teams
         * created_at : 2012-11-29T21:42:50Z
         * updated_at : 2017-03-08T02:00:49Z
         */

        private int id;
        private String name;
        private String username;
        private String html_url;
        private String avatar_url;
        private String bio;
        private String location;
        private LinksBean links;
        private int buckets_count;
        private int comments_received_count;
        private int followers_count;
        private int followings_count;
        private int likes_count;
        private int likes_received_count;
        private int projects_count;
        private int rebounds_received_count;
        private int shots_count;
        private int teams_count;
        private boolean can_upload_shot;
        private String type;
        private boolean pro;
        private String buckets_url;
        private String followers_url;
        private String following_url;
        private String likes_url;
        private String projects_url;
        private String shots_url;
        private String teams_url;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public LinksBean getLinks() {
            return links;
        }

        public void setLinks(LinksBean links) {
            this.links = links;
        }

        public int getBuckets_count() {
            return buckets_count;
        }

        public void setBuckets_count(int buckets_count) {
            this.buckets_count = buckets_count;
        }

        public int getComments_received_count() {
            return comments_received_count;
        }

        public void setComments_received_count(int comments_received_count) {
            this.comments_received_count = comments_received_count;
        }

        public int getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }

        public int getFollowings_count() {
            return followings_count;
        }

        public void setFollowings_count(int followings_count) {
            this.followings_count = followings_count;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public int getLikes_received_count() {
            return likes_received_count;
        }

        public void setLikes_received_count(int likes_received_count) {
            this.likes_received_count = likes_received_count;
        }

        public int getProjects_count() {
            return projects_count;
        }

        public void setProjects_count(int projects_count) {
            this.projects_count = projects_count;
        }

        public int getRebounds_received_count() {
            return rebounds_received_count;
        }

        public void setRebounds_received_count(int rebounds_received_count) {
            this.rebounds_received_count = rebounds_received_count;
        }

        public int getShots_count() {
            return shots_count;
        }

        public void setShots_count(int shots_count) {
            this.shots_count = shots_count;
        }

        public int getTeams_count() {
            return teams_count;
        }

        public void setTeams_count(int teams_count) {
            this.teams_count = teams_count;
        }

        public boolean isCan_upload_shot() {
            return can_upload_shot;
        }

        public void setCan_upload_shot(boolean can_upload_shot) {
            this.can_upload_shot = can_upload_shot;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isPro() {
            return pro;
        }

        public void setPro(boolean pro) {
            this.pro = pro;
        }

        public String getBuckets_url() {
            return buckets_url;
        }

        public void setBuckets_url(String buckets_url) {
            this.buckets_url = buckets_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public void setFollowers_url(String followers_url) {
            this.followers_url = followers_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public void setFollowing_url(String following_url) {
            this.following_url = following_url;
        }

        public String getLikes_url() {
            return likes_url;
        }

        public void setLikes_url(String likes_url) {
            this.likes_url = likes_url;
        }

        public String getProjects_url() {
            return projects_url;
        }

        public void setProjects_url(String projects_url) {
            this.projects_url = projects_url;
        }

        public String getShots_url() {
            return shots_url;
        }

        public void setShots_url(String shots_url) {
            this.shots_url = shots_url;
        }

        public String getTeams_url() {
            return teams_url;
        }

        public void setTeams_url(String teams_url) {
            this.teams_url = teams_url;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public static class LinksBean {
            /**
             * web : http://www.eranmendel.com/
             */

            private String web;

            public String getWeb() {
                return web;
            }

            public void setWeb(String web) {
                this.web = web;
            }
        }
    }
}
