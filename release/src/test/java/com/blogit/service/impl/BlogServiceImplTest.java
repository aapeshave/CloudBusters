package com.blogit.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blogit.entity.BlogEntity;
import com.blogit.pojo.User;
import com.blogit.repositories.BlogRepository;
import com.blogit.repositories.UserRepository;
import com.blogit.service.BlogService;

/**
 * 
 * @author kruti
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {
	@Autowired
	private BlogService blogService;

	@Autowired
	private UserRepository userRepository;

	private BlogEntity blogEntity;

	@Before
	public void setUp() throws Exception {
		blogEntity = new BlogEntity();
		blogEntity.setBlogName("Test_Blog");
		blogEntity.setBlogDescription("This is a test blog desc");
	}

	@Test
	public void createBlog() throws Exception {
		User user = new User("Test_firstname", "Test_lastname");
		userRepository.save(user);
		blogEntity.setUserID(user.getId());

		String blog = blogService.createBlog(blogEntity);
		Assert.assertNotNull("Assert that blog is created", blog);
	}

	@Test
	public void deleteBlog() throws Exception {
		String blogId = blogService.createBlog(blogEntity);
		Assert.assertNotNull("Assert that blog is created", blogId);

		Boolean result = blogService.deleteBlog(blogId);
		Assert.assertTrue("Assert that token is deleted", result);
	}
}