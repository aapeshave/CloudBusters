package com.blogit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ameyutturkar on 4/26/17.
 */
@Controller
public class LogoutController
{
    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        session.removeAttribute(userId);
        session.invalidate();
        response.sendRedirect("/login");
    }
}
