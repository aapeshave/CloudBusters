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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public String signupAction(@ModelAttribute SignupEntity signupEntity, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = signUpService.createUserAccount(signupEntity);
        HttpSession session = request.getSession();
        if (userId != null) {
            signupEntity.setId(userId);
            if(session.getAttribute("userId") == null)
            {
                session.setAttribute("userId", userId);
            }
            return "signupSuccess";
        }
        model.addAttribute("signupError", true);
        return "signup";
    }
}
