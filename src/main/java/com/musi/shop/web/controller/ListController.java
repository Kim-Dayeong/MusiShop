package com.musi.shop.web.controller;

import com.musi.shop.web.Service.AlbumService;
import com.musi.shop.web.response.AlbumListResponse;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller

@RequiredArgsConstructor
public class ListController { //album, user, item 등 list

    private final AlbumService albumService;

    @GetMapping("/albumlist")
    public String albumlist(Model model) {
        List<AlbumListResponse> albumListResponseList = albumService.AlbumList();
        model.addAttribute("albumlist",albumListResponseList);
        return "albumlist.html";
    }

}
