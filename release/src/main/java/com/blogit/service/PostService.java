package com.blogit.service;

import com.blogit.entity.PostEntity;

/**
 * @author kruti
 */
public interface PostService {

    /**
     * @param postEntity is received from UI
     * @return id of post created
     * @throws Exception
     */
    String createPost(PostEntity postEntity) throws Exception;

    /**
     * @param post
     * @return true is successfully deleted
     */
    Boolean deletePost(String post);
}
