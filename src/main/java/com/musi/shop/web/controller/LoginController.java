package com.musi.shop.web.controller;

import com.musi.shop.web.Service.LoginService;
import com.musi.shop.web.web.domain.LoginForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RestController

@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;



//    @PostMapping("/login")
//    public ModelAndView login(@Valid LoginForm loginVO, BindingResult result,
//                              RedirectAttributes redirect, HttpServletRequest request, HttpServletResponse response)throws Exception {
//
//        System.out.println("---------------------> " + loginVO.getLoginId());
//        System.out.println("---------------------> " + loginVO.getPassword());
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

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm) {
        String userid = loginForm.getEmail();
        String userpw = loginForm.getPassword();
         return String.format("받은값!!!!!!!!!!"+userid+userpw);


    }







}
