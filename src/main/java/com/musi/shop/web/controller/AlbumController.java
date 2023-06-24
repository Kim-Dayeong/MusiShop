package com.musi.shop.web.controller;

import com.musi.shop.web.Service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AlbumController {

    AlbumService albumService;

    @GetMapping("/album/list")
    public String albumList(Model model){
        //albumservice에서 생성한 리스트를 변수명 list로 반환
        model.addAttribute("list",albumService.albumList());
        return "albumlist";

    }
}
