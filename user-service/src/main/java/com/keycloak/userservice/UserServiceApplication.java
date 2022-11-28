package com.keycloak.userservice;

import com.keycloak.userservice.config.PathBasedConfigResolver;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	@Bean
	@ConditionalOnMissingBean(PathBasedConfigResolver.class)
	public KeycloakConfigResolver keycloakConfigResolver() {
		return new PathBasedConfigResolver();
	}
}
