package com.blogit.entity;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public class BlogEntity {

	private String blogName;
	private String blogDescription;
    private String userID;
    
    public BlogEntity() throws NoSuchPaddingException, NoSuchAlgorithmException {

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
