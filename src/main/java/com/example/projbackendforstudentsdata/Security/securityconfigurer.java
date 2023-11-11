package com.example.projbackendforstudentsdata.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
public class securityconfigurer {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails Super_Admin= User
                .withUsername("Super_Admin")
                .password(passwordEncoder().encode("Pssspsss"))
                .roles("Super_Admin")
                .build();
        UserDetails Admin=User
                .withUsername("Admin")
                .password(passwordEncoder().encode("pssspsss"))
                .roles("Admin")
                .build();
        return new InMemoryUserDetailsManager(Super_Admin,Admin);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/Data/Home")
                .permitAll()
                .requestMatchers("/Data/All")
                .hasRole("Super_Admin")
                .requestMatchers("/Data/Add")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }
}
