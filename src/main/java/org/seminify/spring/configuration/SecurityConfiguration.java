package org.seminify.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                return httpSecurity
                                .authorizeHttpRequests(authorizeHttpRequest -> authorizeHttpRequest
                                                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                                .anyRequest().authenticated())
                                .csrf(CsrfConfigurer::disable).httpBasic(Customizer.withDefaults()).build();
        }

        @Bean
        OpenAPI openAPI() {
                return new OpenAPI()
                                .components(new Components().addSecuritySchemes("basicScheme",
                                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                                .addSecurityItem(new SecurityRequirement().addList("basicScheme"));
        }
}
