package com.example.login.controller;

import com.example.login.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute User user) {
        if ("admin".equals(user.getUsername()) && "Wipro@123".equals(user.getPassword())) {
            return "success";
        } else {
            return "failure";
        }
    }
}
