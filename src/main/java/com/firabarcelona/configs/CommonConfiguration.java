package com.firabarcelona.configs;

import com.firabarcelona.PermitEntryPoints;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

/**
 * @author Sergio López
 * @created 10/11/2020
 */
@Configuration
public class CommonConfiguration implements RepositoryRestConfigurer {

        @Value("${fira.api.version}")
        private String apiVersion;

        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            //config.exposeIdsFor(EntityToExposeId.class);
            config.setBasePath(apiVersion);
        }


        //Si se elimina /error de los entrypoints arrojará un 401 en las peticiones públicas.
        @Bean
        public PermitEntryPoints getPermitEntryPoints() {
            return () -> new String[]{
                    "/health",
                    "/error"
            };
        }
}
