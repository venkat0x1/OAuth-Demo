//package com.oauth.demo.security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
//
//        httpSecurity.csrf(csrf -> csrf.disable())
//
//        return httpSecurity.build();
//    }
//}
