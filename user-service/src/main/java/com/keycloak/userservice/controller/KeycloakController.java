package com.keycloak.userservice.controller;

import com.keycloak.userservice.service.KeycloakService;
import org.keycloak.adapters.jetty.core.AbstractKeycloakJettyAuthenticator;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class KeycloakController {

    @Autowired
    KeycloakService keycloakService;

    // UI Pages
    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users",keycloakService.getAllUser());
        return "users";
    }

    @GetMapping("/user_create")
    public String getUserCreationPage(){
        return "user_create";
    }

    @GetMapping("/user_delete")
    public String getUserdeletionPage(){
        return "user_delete";
    }

    // Backend APIS
    @PostMapping("/addUser")
    public String addNewRealm(@ModelAttribute  UserRepresentation userRepresentation, Model model){
        userRepresentation.setEnabled(true);
        String createMessage = keycloakService.addUser(userRepresentation);
        model.addAttribute("createMessage",createMessage);
        System.out.println(createMessage);
        return "user_create";
    }

    @GetMapping("/deleteuser")
    public String deleteUser(@RequestParam("userId") String userId, Model model) {
        String deleteMessage = keycloakService.deleteUser(userId);
        model.addAttribute("deleteMessage",deleteMessage);
        System.out.println(deleteMessage);
        return "user_delete";
    }
}
