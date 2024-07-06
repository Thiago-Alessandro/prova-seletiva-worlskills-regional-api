package com.example.prova_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class BeansConfig {

    @Bean
    public CorsConfigurationSource corsConfig(){
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedMethods(List.of("GET","POST","PATCH","PUT", "DELETE"));
        cors.setAllowedOrigins(List.of("http://localhost:4200"));
        cors.setAllowedHeaders(List.of("*"));
//        cors.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", cors);
        return corsConfigurationSource;
    }

}
