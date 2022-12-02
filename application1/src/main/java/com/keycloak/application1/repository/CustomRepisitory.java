package com.keycloak.application1.repository;


import com.keycloak.application1.model.CustomKeycloakDeployment;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface CustomRepisitory extends JpaRepository<CustomKeycloakDeployment,Integer> {
    CustomKeycloakDeployment findByRealm(String realm);
}
