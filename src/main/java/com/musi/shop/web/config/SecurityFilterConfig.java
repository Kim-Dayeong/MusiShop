package com.musi.shop.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityFilterConfig {

    private final JwtTokenProvider jwtTokenProvider;

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
                .loginProcessingUrl("/loginProc") //service에서 메소드 자동 실행(loadUserByUsername) 컨트롤러 x
                .defaultSuccessUrl("/")
                .and().build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
