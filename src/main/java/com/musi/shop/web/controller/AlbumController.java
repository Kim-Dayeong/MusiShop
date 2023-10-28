package com.musi.shop.web.controller;

import com.musi.shop.web.Service.AlbumService;
import com.musi.shop.web.Service.MemberDetailsService;
import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.*;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.MemberRepository;
import com.musi.shop.web.repository.SongRepository;
import com.musi.shop.web.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@Controller
@RequiredArgsConstructor
public class AlbumController {

   private final AlbumService albumService;


    @GetMapping("/album/list")
    public String albumList(Model model, @PageableDefault (page = 0, size = 10, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        //albumservice에서 생성한 리스트를 변수명 list로 반환
        //model.addAttribute("list",albumService.albumList());

        Page<Album> list = albumService.albumList(pageable);

        //페이지 블럭 처리
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage -3, 1);
        int endPage = Math.min(nowPage + 3, list.getTotalPages());
        int starttotal = 0;
        int endtotal = list.getTotalPages()-1;

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("starttotal", starttotal);
        model.addAttribute("endtotal", endtotal);

        return "albumlist.html";
    }


    //앨범 추가 / 추후 아티스트 회원만 접근 가능하게 수정
    @GetMapping("/album/add")
    public String showAlbumForm(Model model) {
        AlbumDto albumdto = new AlbumDto();
        albumdto.setSongs(new ArrayList<>());
        model.addAttribute("albumDto", albumdto);
        return "albumAdd";
    }


    @PostMapping("/album/add")

    public String albumWrite(@RequestBody AlbumDto albumdto,
                             @AuthenticationPrincipal PrincipalDetail principalDetail,
                             Album album

    ){
        System.out.println(albumdto.toString());

        List<SongDto> songDtos = new ArrayList<>();
        for(SongDto songDto : albumdto.getSongs()){
            System.out.println(songDto.toString());
            songDtos.add(songDto);
        }

        String username = principalDetail.getUsername();
        String nickname = principalDetail.getName();

        System.out.println("!!!!!!!!!!!!!유저네임"+nickname);
     //  System.out.println("!!!!!앨범서비스:"+memberadapter.getMember());
        albumService.write(albumdto
               ,songDtos
        , album,username, nickname);


        return "redirect:/";
    }

    //앨범 상세 페이지 조회
    @GetMapping("/album/view/{no}")
    public String albumView(@PathVariable("no") Long id, Model model){
        AlbumDto albumDto = albumService.getAlbumWithSongs(id);

        model.addAttribute("albumDto", albumDto);

        return"albumview.html";
    }


}