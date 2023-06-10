package com.musi.shop.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ViewController {
    @GetMapping("/")
    public String home(){
        return "index.html";
    }
}
