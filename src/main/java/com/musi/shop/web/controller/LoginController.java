package com.musi.shop.web.controller;

import com.musi.shop.web.Service.LoginService;
import com.musi.shop.web.entity.User;
import com.musi.shop.web.web.domain.LoginForm;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }
        User loginUser = loginService.login(form.getLoginId(), form.getPassword());

        log.info("login? {}", loginUser);
        if (loginUser == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀립니다.");
            return "login/loginForm";
        }
        return "redirect:/";

    }


}
