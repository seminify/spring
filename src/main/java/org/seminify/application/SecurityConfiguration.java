package org.seminify.application;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
                return httpSecurity.authorizeHttpRequests(
                                authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                                                .requestMatchers("/open/**").permitAll().requestMatchers("/admin/**")
                                                .hasAuthority("ADMIN").anyRequest().authenticated())
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
