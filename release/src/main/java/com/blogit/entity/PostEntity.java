package com.blogit.entity;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public class PostEntity {
	
	private String content;
	private String blogID;
	
	  public PostEntity() throws NoSuchPaddingException, NoSuchAlgorithmException {

	    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBlogID() {
		return blogID;
	}

	public void setBlogID(String blogID) {
		this.blogID = blogID;
	}
	  
}
