package com.keycloak.realmmicroservice;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {
    private String serverUrl = "http://localhost:8080";
    private String realm = "master";
    private String clientId = "admin-cli";
    private String clientSecret = "";
    private String userName = "admin";
    private String password = "123";
    private String grantType="password";


    @Bean
     public  Keycloak getInstance(){
            Keycloak keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(grantType)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(new ResteasyClientBuilderImpl().connectionPoolSize(10).build())
                    .build();
        System.out.println("Keycloak bean created");
        return keycloak;
    }

}
