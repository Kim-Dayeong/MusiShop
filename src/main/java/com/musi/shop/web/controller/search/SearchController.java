package com.musi.shop.web.controller.search;

import com.musi.shop.web.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    // 통합 제목 검색
    @GetMapping("")
    public String findAlltitle(String keyword, Model model){

        model.addAttribute("album",searchService.searchAlbum(keyword));
        model.addAttribute("community",searchService.searchCommunity(keyword));
        model.addAttribute("board",searchService.searchBoard(keyword));
        model.addAttribute("playlist",searchService.searchPlaylist(keyword));
       model.addAttribute("song",searchService.searchSong(keyword));



        return "/page/search-page";
    }

}
