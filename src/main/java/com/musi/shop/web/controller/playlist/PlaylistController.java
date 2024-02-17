package com.musi.shop.web.controller.playlist;


import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.playlist.PlaylistCreateDto;
import com.musi.shop.web.dto.playlist.PlaylistRequestDto;
import com.musi.shop.web.dto.playlist.PlaylistResponseDto;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.service.playlist.PlaylistService;
import javassist.compiler.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

   // 최신 플레이리스트 전체 보기
   @GetMapping("/playlist/all")
   public String playlistAll(Model model){

       model.addAttribute("playlist",  playlistService.PlaylistAll() );

       return "/playlist/playlist-all";
   }

    // 플레이리스트 생성
    @PostMapping("/playlist/{id}/add")
    public String playlistAdd(@PathVariable Long id, //userid
                              PlaylistCreateDto playlistCreateDto) {
        playlistService.createPlaylist(id, playlistCreateDto);

        return "redirect:/playlist/view/" + id;
    }

    // 내가 만든 플레이리스트 목록 보기
    @GetMapping("/playlist/view")
    public String playlistView(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model){

      model.addAttribute("playlists", playlistService.PlaylistView(principalDetail.getUsername()));

      // 로그인 안됐을때 에러 처리 하기

        return "/playlist/playlist-view";

    }



    // 플레이리스트 디테일 보기
    @GetMapping("/playlist/detail/{id}") //id-> 플레이리스트 id
    public String playlistDetail(@PathVariable Long id, Model model){
      PlaylistResponseDto dto = playlistService.PlaylistDetail(id);
       model.addAttribute("dtos",dto);
        return  "/playlist/playlist-detail";

    }

    // 플레이리스트 수정
    @GetMapping("playlist/update/") //songid
    public String postPlaylistModify(@RequestParam Long songid,
                                     Model model, @AuthenticationPrincipal PrincipalDetail principalDetail
            , HttpServletResponse response, HttpSession httpSession){


    httpSession.setAttribute("songid", songid); // 세션에 songid 저장


       model.addAttribute("playlists", playlistService.PlaylistView(principalDetail.getUsername()));

        return "/playlist/playlist-modify";
    }

    @GetMapping("/playlist/modify/") //songid + listid
    public String getPlaylistUpdate(@RequestParam Long listid,
                                    HttpServletRequest request, Model model,
                                    HttpSession httpSession){




        playlistService.updatePlaylist(listid, (Long) httpSession.getAttribute("songid"));
        model.addAttribute("dto",playlistService.PlaylistDetail(listid));

        httpSession.removeAttribute("songid"); // songid 삭제

        return "/playlist/playlist-detail";

    }







}
