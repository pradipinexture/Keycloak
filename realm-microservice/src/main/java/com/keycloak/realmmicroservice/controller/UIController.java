
package com.keycloak.realmmicroservice.controller;

import com.keycloak.realmmicroservice.service.KeycloakService;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UIController {

    @Autowired
    KeycloakService keycloakService;

    @GetMapping
    public String getAllRealms(Model model){
        model.addAttribute("realms",keycloakService.getAllRealm());
        return "realms";
    }

    @PostMapping("/addRealm")
    public String addNewRealm(@ModelAttribute  RealmRepresentation realmRepresentation, Model model){
        realmRepresentation.setEnabled(true);
        String createMessage = keycloakService.addRealm(realmRepresentation);
        model.addAttribute("createMessage",createMessage);
        System.out.println(createMessage);
        return "realm_create";
    }

    @GetMapping("/deleterealm")
    public String recoverPass(@RequestParam("realm") String realm, Model model) {
        String deleteMessage = keycloakService.deleteRealm(realm);
        model.addAttribute("deleteMessage",deleteMessage);
        System.out.println(deleteMessage);
        return "realm_delete";
    }

    @GetMapping("/realm_create")
    public String getRealmCreationPage(){
        return "realm_create";
    }

    @GetMapping("/realm_delete")
    public String getRealmdeletionPage(){
        return "realm_delete";
    }
}
