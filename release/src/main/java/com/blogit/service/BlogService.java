package com.blogit.service;

import com.blogit.entity.BlogEntity;

/**
 * @author kruti
 */

/**
 * service to create a blog
 */
public interface BlogService {

	/**
	 * @param blogEntity
	 *            is received from UI
	 * @return id of blog created
	 * @throws Exception
	 */
	String createBlog(BlogEntity blogEntity) throws Exception;

	/**
	 * @param blogToBeDeleted
	 *            Object to be deleted
	 * @return true if successfully deleted
	 */
	Boolean deleteBlog(String blog);
}
