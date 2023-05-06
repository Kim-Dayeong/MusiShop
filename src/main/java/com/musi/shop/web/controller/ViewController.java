package com.musi.shop.web.controller;

import com.musi.shop.web.web.domain.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/user")

@RestController
public class ViewController {

    @GetMapping(value = "/signup")
    public ModelAndView userForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userForm.html");

        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Login.html");

        return modelAndView;
    }
}
