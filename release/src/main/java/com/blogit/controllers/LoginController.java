package com.blogit.controllers;

import com.blogit.entity.LoginEntity;
import com.blogit.pojo.User;
import com.blogit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ajinkya on 3/8/17.
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;


    @RequestMapping("/login")
    public String login(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) throws NoSuchAlgorithmException, NoSuchPaddingException {
        model.addAttribute("name", name);
        model.addAttribute("loginEntity", new LoginEntity());
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginAction(@ModelAttribute LoginEntity loginEntity, Model model) throws Exception {
        System.out.println("The encrypted password is " + loginEntity.getPassword());
        User verifiedUser = loginService.validateUserAccount(loginEntity);
        if (verifiedUser != null) {
            model.addAttribute("user", verifiedUser);
            return "userDashboard";
        }
        model.addAttribute("loginError", true);
        return "login";
    }
}

