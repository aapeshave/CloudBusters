package com.blogit.controllers;

import com.blogit.entity.BlogEntity;
import com.blogit.pojo.User;
import com.blogit.service.BlogService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blog")
    public String blog(Model model) throws NoSuchAlgorithmException, NoSuchPaddingException {
        model.addAttribute("blogEntity", new BlogEntity());
        return "hello";
    }

    @PostMapping(value = "/blog")
    public void blogAction(@ModelAttribute BlogEntity blogEntity, Model model, HttpServletResponse response) throws Exception {
        if (model.containsAttribute("user")) {
            Map modelMap = model.asMap();
            User user = (User) modelMap.get("user");
            blogEntity.setUserID(user.getId());
        }
        String blogID = blogService.createBlog(blogEntity);
        blogEntity.setBlogID(blogID);
        response.setStatus(200);
        response.getWriter().write("Blog Created");
    }
}
