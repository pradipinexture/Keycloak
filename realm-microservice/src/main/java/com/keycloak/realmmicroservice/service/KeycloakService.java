package com.keycloak.realmmicroservice.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class KeycloakService {
    @Autowired
    Keycloak keycloak;

    @Autowired
    Environment environment;

    public String addRealm(RealmRepresentation realmRepresentation){
        try{
            keycloak.realms().create(realmRepresentation);
        }
        catch (ClientErrorException e){
            return "Realm already exist.";
        }
        catch (Exception e){
            return "Realm not Created.\n"+e;
        }
        return "Realm Created";
    }

    public List<RealmRepresentation> getAllRealm(){
        return keycloak.realms().findAll();
    }

    public String deleteRealm(String realm){
        try{
            keycloak.realms().realm(realm).remove();
        }
        catch (NotFoundException e){
            return "Realm not found";
        }
        return "Realm Deleted";
    }

    public String addUser(UserRepresentation userRepresentation) {

        UsersResource usersRessourceNew = keycloak.realm("Custom").users();
        usersRessourceNew.create(userRepresentation);
        return "";
    }

    public String deleteUser(String id) {
        getKeycloakRealmInstance().users().delete(id);
        return "User deleted";
    }

    public List<UserRepresentation> getAllUser() {
        RealmResource realmResource =getKeycloakRealmInstance();
        return realmResource.users().list();
    }

    public UserRepresentation getUser(String id) {
        RealmResource realmResource =getKeycloakRealmInstance();
        return realmResource.users().get(id).toRepresentation();
    }

    private RealmResource getKeycloakRealmInstance(){
        return keycloak.realm("Custom");
    }

//    String getRealmProperties(){
//        environment.se
//        return "";
//    }

}