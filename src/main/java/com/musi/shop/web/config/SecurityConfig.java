package com.musi.shop.web.config;

import com.musi.shop.web.config.auth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)

public class SecurityConfig  {

    private final CustomOAuth2UserService customOAuth2UserService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                //.httpBasic().disable()
                .csrf().disable();
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               // .and()
        http
                .authorizeRequests()
                //.antMatchers("/home").permitAll() //해당 api 모든요청 허용
                //.antMatchers("/**").permitAll()
                //.antMatchers("/user/**").authenticated()
                //.antMatchers("/admin/").hasRole("ADMIN")
                .antMatchers("/admin/").denyAll()
                .antMatchers("/artist/**").access("hasRole('ROLE_ARTIST')") //아티스트 페이지
                .antMatchers("/artist").access("hasRole('ROLE_ARTIST')")
                .antMatchers("/album/add").authenticated() //인증된 사용자만 앨범추가 가능
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login") //로그인 페이지 설정
                .loginProcessingUrl("/loginProc")
                .defaultSuccessUrl("/")
                .and()
                .logout() //로그아웃 설정
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout/result")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/user/denied")//403 예외처리 핸들링
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
               // .antMatchers("/members/login").permitAll()
                //.antMatchers("/members/test").hasRole("USER")
                //.anyRequest().authenticated()
                .and();

        return http.build();

    }



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
