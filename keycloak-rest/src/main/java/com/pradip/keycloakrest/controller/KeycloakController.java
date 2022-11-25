package com.pradip.keycloakrest.controller;

import com.pradip.keycloakrest.model.KeycloakUser;
import com.pradip.keycloakrest.service.KeycloakService;
import org.keycloak.admin.client.ClientBuilderWrapper;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/keycloak")
public class KeycloakController {

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping(path = "/create")
    @ResponseBody
    KeycloakUser addUser(KeycloakUser keycloakUser) {
        keycloakService.createAccount("Pradiip demo", "123");
            return keycloakUser;
    }
    @GetMapping("/entity")
    HttpEntity<RealmRepresentation> addRealm() {
        RealmRepresentation realm=new RealmRepresentation();
        realm.setRealm("master");
        realm.setAccountTheme("hello");
        realm.setDisplayName("Name");
        return new HttpEntity<>(realm);
    }
}
