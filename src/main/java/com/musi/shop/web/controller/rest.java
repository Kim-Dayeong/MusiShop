package com.musi.shop.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rest {

    @GetMapping("/test")
    public String test(){
        return"OK";
    }
}
