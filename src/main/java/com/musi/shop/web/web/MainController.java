package com.musi.shop.web.web;

import com.musi.shop.web.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/")
    public String mainView() {
        return "index.html";
    }

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("testSTR", "메인 페이지입니다.");
        return "homeView.html";
    }

    @GetMapping("/albumlist")
    public String albumList(Model model) {
        System.out.println("출력:"+albumService.AlbumList());
        model.addAttribute("list", albumService.AlbumList());
        return "albumlist.html";
    }
}
