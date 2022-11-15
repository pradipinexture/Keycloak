package com.pradip.keycloakrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    @GetMapping
    String getIndexPage(){
        return "index";
    }
}
