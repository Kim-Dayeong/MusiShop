package com.musi.shop.web.controller;

import com.musi.shop.web.Service.UserServiceImpl;
import com.musi.shop.web.repository.UserEntityRepository;
import com.musi.shop.web.web.dto.UserDTO;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller

@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserEntityRepository userEntityRepository;

    private final UserServiceImpl userService;

    @GetMapping("/signupView")
   public String signupPage() {
        return "signup.html";
    }


    @PostMapping("/signup")
    public String userSignup(@RequestBody UserDTO userDTO){
        userService.signup(userDTO);
        return "/";
    }

    //로그인
    @GetMapping("/LoginView")
    public String loginPage() {return "login.html";}

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
       UserDTO loginResult =  userService.login(userDTO);
       if(loginResult != null) {
          session.setAttribute("loginEmail", loginResult.getEmail());
          session.setAttribute("id",loginResult.getId());
          return "/";
       }else {
           return "login.html";
       }
    }



}
