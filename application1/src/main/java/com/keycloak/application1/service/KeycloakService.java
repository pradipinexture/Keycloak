package com.keycloak.application1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keycloak.application1.model.CustomKeycloakDeployment;
import com.keycloak.application1.repository.CustomRepisitory;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class KeycloakService {
    @Autowired
    CustomRepisitory customRepisitory;
    public static String currentRealmName="Custom";

    public CustomKeycloakDeployment getKeycloakDeploymentByRealm(String realm) throws JsonProcessingException {
        return customRepisitory.findByRealm(realm);
    }

    public KeycloakDeployment getFinalKeycloakDep(String realm) throws JsonProcessingException {
        CustomKeycloakDeployment keycloakDeploymentByRealm = getKeycloakDeploymentByRealm(realm);
        if(keycloakDeploymentByRealm != null){
            return KeycloakDeploymentBuilder.build(new ByteArrayInputStream(new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(keycloakDeploymentByRealm).getBytes()));
        }
        return null;
    }

    public List<CustomKeycloakDeployment> getAllKeycloakDeployment(){
        return customRepisitory.findAll();
    }

}
