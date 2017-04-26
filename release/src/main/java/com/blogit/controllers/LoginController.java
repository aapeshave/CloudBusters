package com.blogit.controllers;

import com.blogit.entity.BlogEntity;
import com.blogit.entity.LoginEntity;
import com.blogit.pojo.User;
import com.blogit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ajinkya on 3/8/17.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;


    @RequestMapping("/")
    public String index(Model model) throws NoSuchAlgorithmException, NoSuchPaddingException {
        model.addAttribute("loginEntity", new LoginEntity());
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model) throws NoSuchAlgorithmException, NoSuchPaddingException {
        model.addAttribute("loginEntity", new LoginEntity());
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginAction(@ModelAttribute LoginEntity loginEntity, Model model) throws Exception {
        User verifiedUser = loginService.validateUserAccount(loginEntity);
        if (verifiedUser != null) {
            model.addAttribute("user", verifiedUser);
            model.addAttribute("authorizationToken", verifiedUser.authoriationToken());
            model.addAttribute("BlogEntity", new BlogEntity());
            return "userDashboard";
        }
        model.addAttribute("loginError", true);
        return "login";
    }
}

