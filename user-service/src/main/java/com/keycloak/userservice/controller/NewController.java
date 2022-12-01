package com.keycloak.userservice.controller;

import com.keycloak.userservice.model.CustomKeycloakDeployment;
import com.keycloak.userservice.service.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class NewController {
    @Autowired
    KeycloakService keycloakService;
//    @GetMapping("/")
//    public String getHome() throws IOException {
//        System.out.println("Home");
//        return "redirect:/tenant/branch1/users";
//    }
    @GetMapping("/tenant/branch1/getdep")
    public List<CustomKeycloakDeployment> getHome() throws IOException {
        String s=null;
        System.out.println(s.equals("sedf"));
        return keycloakService.getAllKeycloakDeployment();
    }

    @GetMapping("/tenant/branch1/getdep/{realm}")
    public CustomKeycloakDeployment getHomedep(@PathVariable String realm) throws IOException {
        return keycloakService.getKeycloakDeploymentByRealm(realm);
    }
}
