package com.pradip.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping
    public String getHome(Model model){
        System.out.println("Home API");
        model.addAttribute("name","Pradip Chavda");
        return "home";
    }
}
