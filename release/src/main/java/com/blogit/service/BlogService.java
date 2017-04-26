package com.blogit.service;

import com.blogit.entity.BlogEntity;
import com.blogit.pojo.Blog;

import java.util.List;

/**
 * @author kruti
 */

/**
 * service to create a blog
 */
public interface BlogService {

    /**
     * @param blogEntity is received from UI
     * @return id of blog created
     * @throws Exception
     */
    String createBlog(BlogEntity blogEntity);

    /**
     * @param blog Object to be deleted
     * @return true if successfully deleted
     */
    Boolean deleteBlog(String blog);

    /**
     * @param userID Retrives all the blogs of given userID
     * @return true if successfully retrieved
     */
    List<Blog> findBlogByUserID(String userID);
}
