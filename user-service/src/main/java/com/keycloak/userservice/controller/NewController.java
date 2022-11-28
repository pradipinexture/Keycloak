package com.keycloak.userservice.controller;

import com.keycloak.userservice.service.KeycloakService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class NewController {
    @GetMapping("/")
    public String getHome() throws IOException {
        System.out.println("Home");
        return "redirect:/tenant/branch1/users";
    }
}
