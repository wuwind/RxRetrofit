package com.feng.myapplicationt.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wuhf on 2016/3/24.
 * Description ：
 */
public class UserBean {

    /**
     * avatar_url : https://avatars.githubusercontent.com/u/15240989?v=3
     * created_at : 2015-10-22T01:42:32Z
     * events_url : https://api.github.com/users/wuwind/events{/privacy}
     * followers : 2
     * followers_url : https://api.github.com/users/wuwind/followers
     * following : 3
     * following_url : https://api.github.com/users/wuwind/following{/other_user}
     * gists_url : https://api.github.com/users/wuwind/gists{/gist_id}
     * gravatar_id :
     * html_url : https://github.com/wuwind
     * id : 15240989
     * login : wuwind
     * organizations_url : https://api.github.com/users/wuwind/orgs
     * public_gists : 0
     * public_repos : 5
     * received_events_url : https://api.github.com/users/wuwind/received_events
     * repos_url : https://api.github.com/users/wuwind/repos
     * site_admin : false
     * starred_url : https://api.github.com/users/wuwind/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/wuwind/subscriptions
     * type : User
     * updated_at : 2016-03-20T07:09:25Z
     * url : https://api.github.com/users/wuwind
     */

    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("created_at")
    private String createdAt;
    private String events_url;
    private int followers;
    private String followers_url;
    private int following;
    private String following_url;
    private String gists_url;
    private String gravatar_id;
    private String html_url;
    private int id;
    private String login;
    private String organizations_url;
    private int public_gists;
    private int public_repos;
    private String received_events_url;
    private String repos_url;
    private boolean site_admin;
    private String starred_url;
    private String subscriptions_url;
    private String type;
    private String updated_at;
    private String url;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public int getPublic_gists() {
        return public_gists;
    }

    public void setPublic_gists(int public_gists) {
        this.public_gists = public_gists;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public boolean isSite_admin() {
        return site_admin;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
