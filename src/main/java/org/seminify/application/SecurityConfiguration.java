package org.seminify.application;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.util.List;

import org.seminify.application.authority.AuthorityDTO;
import org.seminify.application.authority.AuthorityMapper;
import org.seminify.application.user.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@EnableWebSecurity
@EnableJdbcHttpSession
public class SecurityConfiguration {
        @Bean
        RoleHierarchyImpl roleHierarchyImpl(AuthorityMapper authorityMapper) {
                return RoleHierarchyImpl.fromHierarchy(String.join(" > ",
                                authorityMapper.get().stream().map(AuthorityDTO::getAuthority).toList()));
        }

        @Bean
        BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
                return httpSecurity
                                .anonymous(anonymousConfigurer -> anonymousConfigurer.principal(new UserDTO()
                                                .setUsername("anonymousUser")
                                                .setAuthorities(List.of(
                                                                new AuthorityDTO().setAuthority("ROLE_ANONYMOUS")))))
                                .authorizeHttpRequests(
                                                authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                                                                .requestMatchers("/anonymous/**").permitAll()
                                                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                                                .anyRequest().authenticated())
                                .csrf(CsrfConfigurer::spa)
                                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
                                                .authenticationEntryPoint((request, response, authException) -> response
                                                                .setStatus(UNAUTHORIZED.value())))
                                .formLogin(formLoginConfigurer -> formLoginConfigurer
                                                .failureHandler((request, response, exception) -> response
                                                                .setStatus(UNAUTHORIZED.value()))
                                                .successHandler((request, response, authentication) -> response
                                                                .setStatus(OK.value())))
                                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessHandler(
                                                (request, response, authentication) -> response.setStatus(OK.value())))
                                .build();
        }
}
