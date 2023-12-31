package com.musi.shop.web.dto.playlist;

import com.musi.shop.web.dto.song.SongDto;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.entity.song.Song;
import lombok.Builder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlaylistResponseDto {

    private Long id;
    private String title;
    private List<SongDto> songs;


    @Builder
    public PlaylistResponseDto(Playlist playlist){
        this.id = playlist.getId();
        this.title = playlist.getTitle();

        if (playlist.getSongs() != null){ // song 엔티티 리스트 -> songdto 리스트
            this.songs = playlist.getSongs().stream().map(SongDto::new).collect(Collectors.toList());
        }
    }
}
