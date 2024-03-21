package com.musi.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class view {

    @GetMapping("/testviewview")
    public String mainView(Model model) {

        return "testviewview";

    }
}
