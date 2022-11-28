package com.keycloak.userservice.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Service
public class KeycloakService {
    @Autowired
    Keycloak keycloak;

    public static String currentRealmName="Custom";
    public String addRealm(RealmRepresentation realmRepresentation){
        try{
            keycloak.realms().create(realmRepresentation);
        }
        catch (Exception e){
            return "Realm not Created"+e;
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
        return "Realm deleted";
    }

    public String addUser(UserRepresentation userRepresentation) {

        // Static Data
        userRepresentation.setEnabled(true);
        userRepresentation.getCredentials().get(0).setTemporary(false);
        userRepresentation.getCredentials().get(0).setType(CredentialRepresentation.PASSWORD);

        try {
            Response response = getKeycloakRealmInstance().users().create(userRepresentation);
            if(response.getStatus() != 201)
                throw new Exception("Error from keycloak and status code"+response.getStatus());
        }
        catch (Exception e){
            return "User not created\n"+e;
        }
        return "User Created";
    }

    public String deleteUser(String id) {
        try{
            getKeycloakRealmInstance().users().delete(id);
        }
        catch (NotFoundException e){
            return "User not found";
        }
        catch (Exception e){
            return "User not deleted";
        }
        return "User Deleted";
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
        return keycloak.realm(currentRealmName);
    }
}
