package com.ceiba.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {


    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${server.allowedOrigins}")
    private String urlConsumidoresApiPermitidos;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(urlConsumidoresApiPermitidos).allowedMethods("GET", "POST", "DELETE", "PUT");
    }
}