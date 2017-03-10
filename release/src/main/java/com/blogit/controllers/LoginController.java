package com.blogit.controllers;

import com.blogit.Entity.LoginEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ajinkya on 3/8/17.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("loginEntity", new LoginEntity());
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginAction(@ModelAttribute LoginEntity loginEntity, BindingResult result) {
        return "result";
    }

}

