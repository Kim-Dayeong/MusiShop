package com.musi.shop.web.controller;

import com.musi.shop.web.Service.LoginService;
import com.musi.shop.web.web.domain.LoginForm;

import com.musi.shop.web.web.dto.TokenDto;
import com.musi.shop.web.web.dto.UserLoginRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody UserLoginRequestDto userLoginRequestDto){
        String email = userLoginRequestDto.getEmail();
        String pwd = userLoginRequestDto.getPwd();
        TokenDto tokenDto = loginService.login(email,pwd);
        return tokenDto;
    }

    @PostMapping("/test")
    public String test() {
        return "sucess";
    }








}
