package com.pradip.keycloakdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    @RequestMapping
    public String gePublicPage(){
        return "home";
    }

    @RequestMapping("/user")
    public String getHomePage(){
        return "user";
    }

    @RequestMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

    @RequestMapping("/accessdenied")
    public String getAccessDenied(){
        return "accessdenied";
    }
}
