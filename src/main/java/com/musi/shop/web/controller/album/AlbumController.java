package com.musi.shop.web.controller.album;

import com.musi.shop.web.service.album.AlbumService;
import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.dto.album.AlbumDto;
import com.musi.shop.web.dto.song.SongDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

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

        return "album/albumlist";
    }

    //앨범 추가 / 추후 아티스트 회원만 접근 가능하게 수정
    @GetMapping("/album/add")
    public String showAlbumForm(Model model) {
        AlbumDto albumdto = new AlbumDto();
        albumdto.setSongs(new ArrayList<>());
        model.addAttribute("albumDto", albumdto);
        return "album/album-add";
    }


    @PostMapping("/album/add")

    public String albumWrite(@RequestBody AlbumDto albumdto,
                             @AuthenticationPrincipal PrincipalDetail principalDetail,
                             Album album){
        System.out.println(albumdto.toString());

        List<SongDto> songDtos = new ArrayList<>();
        for(SongDto songDto : albumdto.getSongs()){
            System.out.println(songDto.toString());
            songDtos.add(songDto);
        }

      String username = principalDetail.getUsername();
        String nickname = principalDetail.getName();
        albumService.write(albumdto,songDtos, album,username, nickname);


        return "redirect:/";
    }

    //앨범 상세 페이지 조회
    @GetMapping("/album/view/{no}")
    public String viewAlbum(@PathVariable("no") Long no, Model model){
        System.out.println("!!!!!!!!!!!!!!!!!!!"+no);
        AlbumDto albumDto = albumService.getAlbumWithSongs(no);

        model.addAttribute("albumDto", albumDto);

        return"album/albumview";
    }


}
