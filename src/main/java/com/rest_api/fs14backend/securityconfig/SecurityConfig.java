package com.rest_api.fs14backend.securityconfig;

import com.rest_api.fs14backend.filters.JwtFilter;
import com.rest_api.fs14backend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/users","/signup", "/signin", "api/v1/products/","api/v1/products/id/{id}", "api/v1/products/search","api/v1/categories/","/api/v1/statics/", "/api/v1/statics/clicks/{id}")
                .permitAll()
                .requestMatchers(HttpMethod.PUT,"/users","api/v1/products/delete/{id}","api/v1/products/restore/{id}","api/v1/deleteAll/","api/v1/restoreAll/")
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"api/v1/products/add")
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/v1/carts/{userId}") // Add this line
                .authenticated()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic(withDefaults()).formLogin()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}