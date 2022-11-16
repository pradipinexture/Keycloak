package com.pradip.keycloakdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

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

    @RequestMapping("/superadmin")
    public String getSuperAdminPage(){
        return "/superadmin";
    }

    @RequestMapping("/accessdenied")
    public String getAccessDenied(){
        return "accessdenied";
    }
}
