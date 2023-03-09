package com.musi.shop.web.controller;

import com.musi.shop.web.Service.UserServiceImpl;
import com.musi.shop.web.repository.UserEntityRepository;
import com.musi.shop.web.web.dto.SignUpFormDTO;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller

@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserEntityRepository userEntityRepository;

    private final UserServiceImpl userService;


    @PostMapping("/signup")
    public ResponseEntity userSignup(@RequestBody SignUpFormDTO signUpFormDTO){
        return userService.signup(signUpFormDTO);
    }



}
