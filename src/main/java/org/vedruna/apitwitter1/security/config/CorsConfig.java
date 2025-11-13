package org.vedruna.apitwitter1.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration cfg = new CorsConfiguration();
    // Con JWT (Bearer) no necesitas credenciales del navegador
    cfg.setAllowCredentials(false);
    cfg.addAllowedOriginPattern("*"); // permite cualquier origen (útil en dev)
    cfg.addAllowedHeader("*");        // incluye Authorization, Content-Type, etc.
    cfg.addAllowedMethod("*");        // GET, POST, PUT, PATCH, DELETE, OPTIONS

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", cfg); // aplica a todas las rutas
    return new CorsFilter(source);
  }
}
