package com.musi.shop.web.controller.view;

import com.musi.shop.web.dto.album.AlbumDto;
import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.service.album.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainviewController {

    @Autowired
    private AlbumService albumService;



    @GetMapping("/")
    public String mainView(Model model) {

        // 인기 앨범 불러오기
        Album bestAlbum =  albumService.bestAlbum();
        System.out.println(bestAlbum);

        // 최신 앨범 불러오기 (4개)
        List<Album> albumList = albumService.newAlbum();
        System.out.println(albumList);

        model.addAttribute("albumDtoList", albumList);
        // 앨범 리스트 출력
        for (Album album : albumList) {
            System.out.println("Title: " + album.getTitle());
            System.out.println("Image: " + album.getImg());
            System.out.println("Release Date: " + album.getRegdate());
            System.out.println();
        }

       model.addAttribute("bestAlbum", bestAlbum);

        return "/index";

    }

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("testSTR", "메인 페이지입니다.");
        return "homeView.html";
    }

    @GetMapping(value = "/userlogin")
    public ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");

        return modelAndView;
    }

    @GetMapping(value = "/join")
    public ModelAndView userForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/member/join-select.html");

        return modelAndView;
    }

    @GetMapping(value = "/userjoin")
    public ModelAndView userjoin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/join.html");

        return modelAndView;
    }

    @GetMapping(value = "/artjoin")
    public ModelAndView artjoin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("artjoin.html");

        return modelAndView;
    }

    @GetMapping(value = "/artist")
    public ModelAndView artist() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("artistview.html");

        return modelAndView;
    }


    @GetMapping(value = "/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminview.html");

        return modelAndView;
    }


}
