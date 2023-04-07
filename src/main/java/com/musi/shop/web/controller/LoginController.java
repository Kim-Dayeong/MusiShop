package com.musi.shop.web.controller;

import com.musi.shop.web.Service.LoginService;
import com.musi.shop.web.entity.User;
import com.musi.shop.web.web.domain.LoginForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public ModelAndView loginForm(@ModelAttribute LoginForm loginVO,
                                  HttpServletRequest request) throws IOException {

        return  new ModelAndView("login.html");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginForm loginVO, BindingResult result,
                              RedirectAttributes redirect, HttpServletRequest request, HttpServletResponse response)throws Exception {

        System.out.println("---------------------> " + loginVO.getLoginId());
        System.out.println("---------------------> " + loginVO.getPassword());
//        if(bindingResult.hasErrors()){
//            return "error";
//        }
//        User loginUser = loginService.login(form.getLoginId(), form.getPassword());
//
//        log.info("login? {}", loginUser);
//        if (loginUser == null){
//            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀립니다.");
//            return "redirect:/";
//        }
    return new ModelAndView("/");
    }




}
