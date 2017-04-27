package com.blogit.controllers;

import com.blogit.entity.BlogEntity;
import com.blogit.pojo.Blog;
import com.blogit.pojo.User;
import com.blogit.service.BlogService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping(value = "/blog")
    public void blogAction(@ModelAttribute BlogEntity blogEntity,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            blogEntity.setUserID(user.getId());
            String blogID = blogService.createBlog(blogEntity);
            blogEntity.setBlogID(blogID);
        } else {
            response.sendRedirect("/login");
        }
        String blogID = blogService.createBlog(blogEntity);
        blogEntity.setBlogID(blogID);
        response.setStatus(200);
        response.getWriter().write("Blog Created");
    }

    @PostMapping(value = "/getBlogList")
    public void getBlogList(@ModelAttribute BlogEntity blogEntity,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Gson gson = new Gson();
            List<Blog> blogByUserID = blogService.findBlogByUserID(user.getId());
            if (blogByUserID != null) {
                response.getWriter().write(gson.toJson(blogByUserID));
            }
        } else {
            response.sendRedirect("/login");
        }
    }
}