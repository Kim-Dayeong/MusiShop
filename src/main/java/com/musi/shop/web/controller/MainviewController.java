package com.musi.shop.web.controller;

import com.musi.shop.web.Service.AlbumService;
import com.musi.shop.web.response.AlbumListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping(value = "/login")
    public ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");

        return modelAndView;
    }

    @GetMapping(value = "/signup")
    public ModelAndView userForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userForm.html");

        return modelAndView;
    }

//    @GetMapping("/albumlist")
//    public String albumList(Model model) {
//        System.out.println("출력:"+albumService.AlbumList());
//        model.addAttribute("list", albumService.AlbumList());
//        return "albumlist.html";
//    }

//    @GetMapping("/albumlist")
//    public String albumlist(Model model) {
//        List<AlbumListResponse> albumListResponseList = albumService.AlbumList();
//        model.addAttribute("albumlist",albumListResponseList);
//        return "albumlist.html";
//    }
}
