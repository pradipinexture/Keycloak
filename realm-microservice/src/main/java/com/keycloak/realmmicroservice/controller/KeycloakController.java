package com.keycloak.realmmicroservice.controller;

import java.util.*;

import com.keycloak.realmmicroservice.service.KeycloakService;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KeycloakController {
    @Autowired
    KeycloakService keycloakService;

    @GetMapping
    public List<RealmRepresentation> getAllRealms(){
        return keycloakService.getAllRealm();
    }

    @PostMapping
    public String addRealm(@RequestBody RealmRepresentation realmRepresentation){
        return keycloakService.addRealm(realmRepresentation);
    }

    @PutMapping
    public String updateRealm(@RequestBody RealmRepresentation realmRepresentation){
        return keycloakService.addRealm(realmRepresentation);
    }

    @DeleteMapping("/{realm}")
    public String deleteRealm(@PathVariable String realm){
       return keycloakService.deleteRealm(realm);
    }

    @GetMapping("/user/{id}")
    public UserRepresentation getUser(@PathVariable String id){
        return keycloakService.getUser(id);
    }

    @GetMapping("/user")
    public List<UserRepresentation> getAllUser(){
        return keycloakService.getAllUser();
    }


    @PostMapping("/user")
    public String addUser(@RequestBody UserRepresentation userRepresentation){
        return keycloakService.addUser(userRepresentation);
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody UserRepresentation userRepresentation){
        return keycloakService.addUser(userRepresentation);
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable String userId){
        return keycloakService.deleteUser(userId);
    }

    //    @PostMapping
//    public String addRealm(@RequestBody RealmRepresentation realmRepresentation2){
//                RealmRepresentation realmRepresentation=new RealmRepresentation();
//        realmRepresentation.setDisplayName("Sandip");
//        realmRepresentation.setRealm("Sandip");
//        realmRepresentation.setEnabled(true);
////        try{
//            keycloak.realms().create(realmRepresentation);
////        }
////        catch (Exception e){
////            return "Realm not Created";
////        }
//        return "Realm Created";
//    }


//    @GetMapping
//    public String getString() {
//        TokenManager tokenManager = keycloak.tokenManager();
//        tokenManager.getAccessToken();
//        String accessTokenString = tokenManager.getAccessTokenString();
//        RealmResource realmResource = keycloak.realm("Custom");
//
//        UsersResource usersRessource = realmResource.users();
//        List<UserRepresentation> list = usersRessource.list();
//        for(UserRepresentation representation:list) {
//            System.out.println("Email : "+representation.getEmail());
//        }
//
//
//        CredentialRepresentation credential = Credentials
//                .createPasswordCredentials("123");
//        UserRepresentation user = new UserRepresentation();
//        user.setUsername("SpringBoot");
//        user.setFirstName("Spring");
//        user.setLastName("SpringBoot");
//        user.setEmail("spring@gamil.com");
//        user.setCredentials(Collections.singletonList(credential));
//        user.setEnabled(true);
//
//        UsersResource usersRessourceNew = realmResource.users();
//        usersRessourceNew.create(user);
//
////        RealmRepresentation realm = new RealmRepresentation();
////        realm.setId("testRealmId");
////        realm.setRealm("testRealm");
////        realm.setEnabled(true); // may be unecessary
////        keycloak.realms().create(realm);
////        realm.setRealm("demo");
//////        realm.set... // all the realm attributes to set
////        keycloak.realms().create(realm);
//
////        try{
////            RealmRepresentation realmRepresentation=new RealmRepresentation();
////            realmRepresentation.setRealm("Pradip");
////            realmRepresentation.setEnabled(true);
////
//////            keycloak.realms().realm("Pradip").remove();
////
////            keycloak.realms().create(realmRepresentation);
////
////        }
////        catch (Exception e){
////            System.out.println("Exception in realm creation"+ e);
////        }
//        return "Success";
//    }


//        @PostMapping(path = "/create")
//        public ResponseEntity<?> createUser() {
//            KeycloakUser userDTO=new KeycloakUser("postman@gmail.com","123","Pradip","Postman","true");
//            Keycloak keycloak = KeycloakBuilder.builder().serverUrl("http://localhost:8080")
//                    .grantType(OAuth2Constants.PASSWORD).realm("master").clientId("custom-realm-management")
//                    .username("admin").password("123")
//                    .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();
//            keycloak.tokenManager()
//            keycloak.tokenManager().getAccessToken();
//            UserRepresentation user = new UserRepresentation();
//            user.setEnabled(true);
//            user.setUsername(userDTO.getEmail());
//            user.setFirstName(userDTO.getFirstname());
//            user.setLastName(userDTO.getLastname());
//            user.setEmail(userDTO.getEmail());
//
//            // Get realm
//            RealmResource realmResource = keycloak.realm("Test");
//            UsersResource usersRessource = realmResource.users();
//
//            Response response = usersRessource.create(user);
//
//            userDTO.setStatusCode(response.getStatus());
//            userDTO.setStatus(response.getStatusInfo().toString());
//
//            if (response.getStatus() == 201) {
//
//                String userId = CreatedResponseUtil.getCreatedId(response);
//
//                System.out.println("Created userId {}"+ userId);
//
//
//                // create password credential
//                CredentialRepresentation passwordCred = new CredentialRepresentation();
//                passwordCred.setTemporary(false);
//                passwordCred.setType(CredentialRepresentation.PASSWORD);
//                passwordCred.setValue(userDTO.getPassword());
//
//                UserResource userResource = usersRessource.get(userId);
//
//                // Set password credential
//                userResource.resetPassword(passwordCred);
//
//                // Get realm role student
//                RoleRepresentation realmRoleUser = realmResource.roles().get("user").toRepresentation();
//
//                // Assign realm role student to user
//                userResource.roles().realmLevel().add(Arrays.asList(realmRoleUser));
//            }
//            return ResponseEntity.ok(userDTO);
//        }
}
