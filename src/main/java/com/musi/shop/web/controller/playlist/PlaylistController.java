package com.musi.shop.web.controller.playlist;


import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.playlist.PlaylistCreateDto;
import com.musi.shop.web.dto.playlist.PlaylistRequestDto;
import com.musi.shop.web.dto.playlist.PlaylistResponseDto;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.service.playlist.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    // 플레이리스트 생성
    @PostMapping("/playlist/{id}/add")
    public String playlistAdd(@PathVariable Long id, //userid
                              PlaylistCreateDto playlistCreateDto) {
        playlistService.createPlaylist(id, playlistCreateDto);

        return "redirect:/playlist/view/" + id;
    }

    // 플레이리스트 목록 보기
    @GetMapping("/playlist/view/{id}")
    public String playlistView(@PathVariable Long id, Model model){// id -> 멤버 id
      model.addAttribute("playlists", playlistService.PlaylistView(id));

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
            , HttpServletRequest request){

        HttpSession session = request.getSession();
       model.addAttribute("playlists", playlistService.PlaylistView(principalDetail.getUsername()));
        session.setAttribute("songid", songid);
        return "/playlist/playlist-modify";
    }

    @GetMapping("/playlist/modify/") //songid + listid
    public String getPlaylistUpdate(@RequestParam Long listid,
    HttpServletRequest request, Model model){

        HttpSession session = request.getSession();
        Long songid = (Long) session.getAttribute("songid");
        playlistService.updatePlaylist(listid, songid);
        model.addAttribute("dto",playlistService.PlaylistDetail(listid));
       session.invalidate(); //  세션방식은 로그인까지 같이 풀어버림 , 수정

        return "/playlist/playlist-detail";

    }







}
