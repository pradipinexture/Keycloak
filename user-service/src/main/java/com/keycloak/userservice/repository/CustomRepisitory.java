package com.keycloak.userservice.repository;


import com.keycloak.userservice.model.CustomKeycloakDeployment;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface CustomRepisitory extends JpaRepository<CustomKeycloakDeployment,Integer> {
    CustomKeycloakDeployment findByRealm(String realm);
}
