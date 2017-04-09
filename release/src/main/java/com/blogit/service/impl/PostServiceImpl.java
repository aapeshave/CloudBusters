package com.blogit.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogit.entity.PostEntity;
import com.blogit.pojo.Post;
import com.blogit.repositories.PostRepository;
import com.blogit.service.PostService;

/**
 * 
 * @author kruti
 *
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	private Log log = LogFactory.getLog(PostServiceImpl.class);

	public PostServiceImpl() throws NoSuchPaddingException, NoSuchAlgorithmException {

	}

	@Override
	public String createPost(PostEntity postEntity) throws Exception {
		Post toCreate = new Post();
		toCreate.setContent(postEntity.getContent());
		toCreate.setBlogID(postEntity.getBlogID());

		postRepository.save(toCreate);
		return toCreate.getPostID();
	}

	@Override
	public Boolean deletePost(String postDelete) {
		try {
			postRepository.delete(postDelete);
			return Boolean.TRUE;
		} catch (Exception e) {
			log.error(e);
		}
		return Boolean.FALSE;
	}
}
