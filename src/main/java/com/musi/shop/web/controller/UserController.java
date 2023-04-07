package com.musi.shop.web.controller;

import com.musi.shop.web.entity.User;
import com.musi.shop.web.repository.UserEntityRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;

@Slf4j
@RestController

@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserEntityRepository userEntityRepository;



    @GetMapping("/signupView")
   public ModelAndView signupPage() throws IOException {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup.html");
        String testval = "test";
       // modelAndView.addObject("signupview",testval);

        return modelAndView;
    }



//    @PostMapping("/signup")
//   // @RequestMapping(value = "/signup",produces = "application/json", method = RequestMethod.POST)
//    public Users put( @RequestParam String name, @RequestParam String email,@RequestParam String pwd){
//        return userEntityRepository.save(new Users(name, email,pwd));
//
//
//    }

    @PostMapping("/signup")
    // @RequestMapping(value = "/signup",produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<?> put(@RequestParam String name, @RequestParam String email, @RequestParam String pwd){
        userEntityRepository.save(new User(name, email,pwd));
        ModelAndView modelAndView = new ModelAndView();

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(URI.create("/"));

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);





    }

    //로그인
//    @GetMapping("/LoginView")
//    public String loginPage() {return "login.html";}
//
//    //로그인 결과 페이지
//    @GetMapping("/login/result")
//    public String LoginResultview() {
//        return "/loginSucess";
//    }
//
//    //로그아웃 결과 페이지
//    @GetMapping("/logout/result")
//    public String Logoutview() {
//        return "/logout";

    }






