package com.blogit.entity;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class PostEntity {
	
	private String content;
    private String userID;
    private String blogID;
    private String postID;

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

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
