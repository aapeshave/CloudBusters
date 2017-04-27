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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

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
        String blogID = blogService.createBlog(blogEntity);
        blogEntity.setBlogID(blogID);
    }

    @PostMapping(value = "/getBlogList")
    public void getBlogList(@ModelAttribute BlogEntity blogEntity,
                            Model model,
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
