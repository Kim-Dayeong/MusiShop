package com.musi.shop.web.controller.member;


import com.musi.shop.web.service.member.MemberpageService;
import com.musi.shop.web.dto.album.AlbumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MemberpageController {

    private final MemberpageService memberpageService;

    //아티스트 페이지 조회
      @GetMapping("/artistpage/{no}")
    public String artistView(@PathVariable("no") Long id, Model model){
        AlbumDto albumDto = memberpageService.getAlbumtitle(id);

        model.addAttribute("albumDto", albumDto);
        System.out.println(albumDto);

        return"artistpage.html";
    }

}
