package com.musi.shop.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilterConfig {

    //권한 부여
   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/loginProc")
                .defaultSuccessUrl("/")
                .and().build();

    }
}
