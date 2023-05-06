package com.musi.shop.web.controller;

import com.musi.shop.web.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainviewController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/")
    public ModelAndView mainView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");

        return modelAndView;

    }

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("testSTR", "메인 페이지입니다.");
        return "homeView.html";
    }

//    @GetMapping("/albumlist")
//    public String albumList(Model model) {
//        System.out.println("출력:"+albumService.AlbumList());
//        model.addAttribute("list", albumService.AlbumList());
//        return "albumlist.html";
//    }
}
