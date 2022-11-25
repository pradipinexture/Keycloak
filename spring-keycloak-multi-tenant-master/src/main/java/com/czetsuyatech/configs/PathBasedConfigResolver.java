package com.czetsuyatech.configs;

import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.keycloak.representations.adapters.config.AdapterConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@ConditionalOnProperty(prefix = "keycloak.config", name = "resolver", havingValue = "path")
public class PathBasedConfigResolver implements KeycloakConfigResolver {

    private final ConcurrentHashMap<String, KeycloakDeployment> cache = new ConcurrentHashMap<>();

    @SuppressWarnings("unused")
    private static AdapterConfig adapterConfig;

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {

        String path = request.getURI();
        int multitenantIndex = path.indexOf("tenant/");

        if (multitenantIndex == -1) {
            throw new IllegalStateException("URL must be like - https://localhost:5555/tenant/realmName/..... ");
        }

        String realm = path.substring(path.indexOf("tenant/")).split("/")[1];
        if (realm.contains("?")) {
            realm = realm.split("\\?")[0];
        }

        if (!cache.containsKey(realm)) {
            InputStream is = getClass().getResourceAsStream("/" + realm + "-keycloak.json");
            if(is != null)
                cache.put(realm, KeycloakDeploymentBuilder.build(is));
            else
                throw new IllegalStateException(realm+ " realm json file not found in project.");

        }

        return cache.get(realm);
    }

    static void setAdapterConfig(AdapterConfig adapterConfig) {
        PathBasedConfigResolver.adapterConfig = adapterConfig;
    }

}