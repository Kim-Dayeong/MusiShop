//package com.musi.shop.web.config;
//
//import com.musi.shop.web.config.auth.CustomOAuth2UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//
//@Configuration
//public class OAuth2SecurityConfig {
//
//
//    @Bean
//    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> oauth2SecurityConfigurerAdapter() {
//        return new OAuth2SecurityConfigurerAdapter();
//    }
//
//    private static class OAuth2SecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
//
//        private CustomOAuth2UserService customOAuth2UserService;
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests()
//                    .antMatchers("/", "/login**", "/error**").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                    .oauth2Login()
//                    .userInfoEndpoint()
//                    .userService(customOAuth2UserService); // OAuth2UserService 빈 주입
//        }
//    }
//}
