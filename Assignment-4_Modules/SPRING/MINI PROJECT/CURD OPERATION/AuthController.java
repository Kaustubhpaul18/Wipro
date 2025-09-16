package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, 
                          @RequestParam String password) {
        if(username.equals("admin") && password.equals("admin")) {
            return "menu";
        }
        return "login";
    }
}
