package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Username/Password required");
            return "login";
        }

        User user = userService.login(username, password);
        if (user == null) {
            model.addAttribute("error", "Invalid Username or Password");
            return "login";
        }

        session.setAttribute("loggedUser", user);
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcomePage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", user.getUsername());
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
