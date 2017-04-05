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

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ameyutturkar on 3/15/17.
 */
@Controller
public class SignupController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping("/signup")
    public String signup(@RequestParam(value = "name", required = true, defaultValue = "Name") String name, Model model) throws NoSuchAlgorithmException, NoSuchPaddingException {
        model.addAttribute("name", name);
        model.addAttribute("signupEntity", new SignupEntity());
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String signupAction(@ModelAttribute SignupEntity signupEntity, Model model) throws Exception {
        String userId = signUpService.createUserAccount(signupEntity);
        if (userId != null) {
            signupEntity.setId(userId);
            return "signupSuccess";
        }
        model.addAttribute("signupError", true);
        return "signup";
    }
}
