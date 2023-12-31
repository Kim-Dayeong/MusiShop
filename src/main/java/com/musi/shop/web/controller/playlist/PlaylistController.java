package com.musi.shop.web.controller.playlist;


import com.musi.shop.web.dto.playlist.PlaylistCreateDto;
import com.musi.shop.web.dto.playlist.PlaylistRequestDto;
import com.musi.shop.web.dto.playlist.PlaylistResponseDto;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.service.playlist.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    // 플레이리스트 추가
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
//    @GetMapping("{id}/playlist/detail") //id-> 플레이리스트 id
//    public String playlistDetail(@PathVariable Long id, Model model){
//        PlaylistResponseDto dto = playlistService.PlaylistView(id);
//        return id + "/playlist/playlist-detail";
//
//    }

    // 플레이리스트 수정
    @GetMapping("{id}/playlist/update")
    public String getPlaylistModift(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        return "/playlist/playlist-modify";

    }

    @PostMapping("{id}/playlist/update")
    public String postPlaylistModify(@PathVariable Long id){

        return id + "/playlist/view/";
    }






}
