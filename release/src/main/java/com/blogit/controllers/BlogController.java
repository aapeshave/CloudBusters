package com.blogit.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogit.entity.BlogEntity;
import com.blogit.pojo.User;
import com.blogit.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping("/blog")
	public void blog(Model model) throws NoSuchAlgorithmException, NoSuchPaddingException {
		model.addAttribute("blogEntity", new BlogEntity());
	}

	@PostMapping(value = "/blog")
	public void blogAction(@ModelAttribute BlogEntity blogEntity, Model model) throws Exception {
		if (model.containsAttribute("user")) {
			Map modelMap = model.asMap();
			User user = (User) modelMap.get("user");
			blogEntity.setUserID(user.getId());
		}
		// cursor should return to login page
		String blog = blogService.createBlog(blogEntity);
		blogEntity.setBlogName(blog);
		;
	}
}
