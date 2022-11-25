package com.example.keycloakdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Scanner;

@Controller
public class FrontController {

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @GetMapping("/user")
    public String userPage(){
        return "user";
    }

    @GetMapping("/public")
    @ResponseBody
    public String publicPage(){
        return "Welcome public";
    }
}
