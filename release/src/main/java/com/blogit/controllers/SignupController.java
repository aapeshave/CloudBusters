package com.blogit.controllers;

import com.blogit.entity.SignupEntity;
import com.blogit.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ameyutturkar on 3/15/17.
 */
@Controller
public class SignupController {

    @Autowired
    SignUpService signUpService;

    @RequestMapping("/signup")
    public String signup(@RequestParam(value = "name", required = true, defaultValue = "Name") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("signupEntity", new SignupEntity());
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String signupAction(@ModelAttribute SignupEntity signupEntity) {
        if (signupEntity != null) {
            String userId = signUpService.createUserAccount(signupEntity);
            if (userId != null) {
                signupEntity.setId(userId);
            }
        }

        return "signupSuccess";
    }
}
