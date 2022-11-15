package com.pradip.keycloakrest.service;

import com.pradip.keycloakrest.model.Credentials;
import com.pradip.keycloakrest.util.KeyCloakUtil;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.stereotype.Service;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;

@Service
public class KeycloakService {
//    @Value("${keycloak.serverUrl}")
//    private String SERVER_URL;
//
//    @Value("${keycloak.realm}")
//    private String REALM;
//
//    @Value("${keycloak.username}")
//    private String USERNAME;
//
//    @Value("${keycloak.password}")
//    private String PASSWORD;
//
//    @Value("${keycloak.clientId}")
//    private String CLIENT_ID;

    private Keycloak getInstance() {
        return KeycloakBuilder
                .builder()
                .serverUrl("http://localhost:8080")
                .username("admin")
                .password("123")
                .realm("mater")
                .clientId("admin-cli")
                .build();
    }

    /**
     * By default KeyCloak REST API doesn't allow to create account with credential type is PASSWORD,
     * it means after created account, need an extra step to make it works, it's RESET PASSWORD
     * @param username
     * @param password
     * @return
     */
    public int createAccount(final String username, final String password) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
            credential.setValue("123");
//        CredentialRepresentation credential = Credentials
//                .createPasswordCredentials("123");
        UserRepresentation user = new UserRepresentation();
        user.setUsername("usernme");
        user.setFirstName("first");
        user.setLastName("last");
        user.setEmail("email");
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);

        getInstance().realm("Custom").users().create(user);
//        instance.create(user);
//        UserRepresentation user = new UserRepresentation();
//        user.setUsername(username);
//        user.setFirstName("First Name");
//        user.setLastName("Last Name");
//        user.singleAttribute("customAttribute", "customAttribute");
//        user.setCredentials(Arrays.asList(credential));
//        getInstance().realm("Custom").users().create(user);
//        javax.ws.rs.core.Response response = getInstance().realm("Custom").users().create(user);
//        final int status = response.getStatus();
//        if (status != HttpStatus.CREATED.value()) {
//            return status;
//        }
//        final String createdId = KeyCloakUtil.getCreatedId(response);
//        // Reset password
//        CredentialRepresentation newCredential = new CredentialRepresentation();
//        UserResource userResource = getInstance().realm("Custom").users().get(createdId);
//        newCredential.setType(CredentialRepresentation.PASSWORD);
//        newCredential.setValue(password);
//        newCredential.setTemporary(false);
//        userResource.resetPassword(newCredential);
        return HttpStatus.CREATED.value();
    }
}
