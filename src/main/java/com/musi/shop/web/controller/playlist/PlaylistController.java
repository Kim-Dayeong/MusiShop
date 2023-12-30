package com.musi.shop.web.controller.playlist;


import com.musi.shop.web.dto.playlist.PlaylistRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PlaylistController {

    // 플레이리스트 보기
    @GetMapping("{id}/playlist/view")
    public String playlistView(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        return "/playlist/playlist-view";

    }

    // 플레이리스트 수정
    @GetMapping("{id}/playlist/update")
    public String getPlaylistModift(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        return "/playlist/playlist-modify";

    }

    @PostMapping("{id}/playlist/update")
    public String postPlaylistModify(@PathVariable Long id, PlaylistRequestDto playlistRequestDto){

        return id + "/playlist/view/";
    }






}
