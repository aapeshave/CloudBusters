package com.blogit.pojo;

import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/*
 * This class contains all the information about individual post
 */
@DynamoDBTable(tableName = "Post")
public class Post {
	
	private String postID;
	private String content;
	private List<String> tags;
	private String postDate;
	private String blogID;
	private int numOfViews;
	private Date createdOn;
	private Date modifiedOn;
	
	public Post() {		
	}	
	public Post(String postID, String content, List<String> tags, String postDate, String blogID, int numOfViews) {
		this();
		this.postID = postID;
		this.content = content;
		this.tags = tags;
		this.postDate = postDate;
		this.blogID = blogID;
		this.numOfViews = numOfViews;
	}
	
	@DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	
	@DynamoDBAttribute
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@DynamoDBAttribute
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@DynamoDBAttribute
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
	@DynamoDBAttribute
	public String getBlogID() {
		return blogID;
	}
	public void setBlogID(String blogID) {
		this.blogID = blogID;
	}
	
	@DynamoDBAttribute
	public int getNumOfViews() {
		return numOfViews;
	}
	public void setNumOfViews(int numOfViews) {
		this.numOfViews = numOfViews;
	}
	
	@DynamoDBAutoGeneratedTimestamp
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@DynamoDBAttribute
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogID == null) ? 0 : blogID.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + numOfViews;
		result = prime * result + ((postDate == null) ? 0 : postDate.hashCode());
		result = prime * result + ((postID == null) ? 0 : postID.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (blogID == null) {
			if (other.blogID != null)
				return false;
		} else if (!blogID.equals(other.blogID))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (numOfViews != other.numOfViews)
			return false;
		if (postDate == null) {
			if (other.postDate != null)
				return false;
		} else if (!postDate.equals(other.postDate))
			return false;
		if (postID == null) {
			if (other.postID != null)
				return false;
		} else if (!postID.equals(other.postID))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Post [postID=" + postID + ", content=" + content + ", tags=" + tags + ", postDate=" + postDate
				+ ", blogID=" + blogID + ", numOfViews=" + numOfViews + "]";
	}
}
