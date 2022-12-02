package com.keycloak.application1;

import com.keycloak.application1.config.PathBasedConfigResolver;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application1Application {

	public static void main(String[] args) {
		SpringApplication.run(Application1Application.class, args);
	}
	@Bean
	@ConditionalOnMissingBean(PathBasedConfigResolver.class)
	public KeycloakConfigResolver keycloakConfigResolver() {
		return new PathBasedConfigResolver();
	}
}
