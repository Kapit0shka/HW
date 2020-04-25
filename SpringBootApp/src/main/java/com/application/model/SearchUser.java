package com.application.model;

public class SearchUser extends User{
    private String userAgent;
    private String time;

    public String getUserAgent() {

        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
