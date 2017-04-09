package com.blogit.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogit.entity.BlogEntity;
import com.blogit.pojo.Blog;
import com.blogit.repositories.BlogRepository;
import com.blogit.service.BlogService;

/**
 * 
 * @author kruti
 *
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	private Log log = LogFactory.getLog(BlogServiceImpl.class);

	public BlogServiceImpl() throws NoSuchPaddingException, NoSuchAlgorithmException {

	}

	@Override
	public String createBlog(BlogEntity blogEntity) throws Exception {
		Blog toCreate = new Blog();
		toCreate.setBlogName(blogEntity.getBlogName());
		toCreate.setBlogDescription(blogEntity.getBlogDescription());
		toCreate.setUserID(blogEntity.getUserID());

		blogRepository.save(toCreate);
		return toCreate.getBlogID();
	}

	@Override
	public Boolean deleteBlog(String blogDelete) {
		try {
			blogRepository.delete(blogDelete);
			return Boolean.TRUE;
		} catch (Exception e) {
			log.error(e);
		}
		return Boolean.FALSE;
	}

}
