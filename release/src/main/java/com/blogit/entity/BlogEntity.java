package com.blogit.entity;

public class BlogEntity {

    private String blogName;
    private String blogDescription;
    private String userID;
    private String blogID;

    public BlogEntity() {

    }

    public BlogEntity(String blogName, String userID) {
        this.blogName = blogName;
        this.userID = userID;
    }

    public String getBlogID() {
        return blogID;
    }

    public void setBlogID(String blogID) {
        this.blogID = blogID;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
