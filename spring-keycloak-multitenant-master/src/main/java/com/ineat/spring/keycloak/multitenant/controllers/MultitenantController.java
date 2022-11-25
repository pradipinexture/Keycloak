package com.ineat.spring.keycloak.multitenant.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultitenantController {

    @RequestMapping(name = "/admin")
    public String adminSecuredEndpoint(){
        return "Documents admin";
    }

    @RequestMapping("/user")
    public String userSecuredEndpoint(){
        return "Documents user";
    }
}