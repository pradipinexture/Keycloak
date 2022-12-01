package com.keycloak.userservice.controller;

import com.keycloak.userservice.User;
import com.keycloak.userservice.dao.CustomRepisitory;
import com.keycloak.userservice.model.CustomKeycloakDeployment;
import com.keycloak.userservice.service.KeycloakService;
import org.keycloak.adapters.jetty.core.AbstractKeycloakJettyAuthenticator;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/tenant")
public class KeycloakController {



    @Autowired
    KeycloakService keycloakService;

    // Set siteName in all APIS
    @ModelAttribute("siteName")
    public String setSiteName(){
        return "www."+KeycloakService.currentRealmName+".com";
    }

    // UI Pages
    @GetMapping("/{realm}/users")
    public String getAllUsers(Model model){
//        CustomKeycloakDeployment deployment=new CustomKeycloakDeployment("branch1","http://localhost:8080","external","web",true);
//        keycloakService.saveKeycloakDeployment(deployment);
//
//        CustomKeycloakDeployment deploymen2=new CustomKeycloakDeployment("branch2","http://localhost:8080","external","web",true);
//        keycloakService.saveKeycloakDeployment(deploymen2);
        model.addAttribute("users",keycloakService.getAllUser());
        return "users";
    }

    @GetMapping("/{realm}/user_create")
    public String getUserCreationPage(){
        return "user_create";
    }

    @GetMapping("/{realm}/user_delete")
    public String getUserdeletionPage(){
        return "user_delete";
    }

    // Backend APIS
    @PostMapping("/{realm}/addUser")
    public String addNewRealm(@ModelAttribute UserRepresentation user, Model model){
        String createMessage = keycloakService.addUser(user);
        model.addAttribute("createMessage",createMessage);
        System.out.println(createMessage);

        return "user_create";
    }

    @GetMapping("/{realm}/deleteuser")
    public String deleteUser(@RequestParam("userId") String userId, Model model) {
        String deleteMessage = keycloakService.deleteUser(userId);
        model.addAttribute("deleteMessage",deleteMessage);
        System.out.println(deleteMessage);
        return "user_delete";
    }


}
