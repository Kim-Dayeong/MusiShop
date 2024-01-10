package com.musi.shop.web.dto.playlist;

import com.musi.shop.web.dto.song.SongDto;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.entity.song.Song;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
public class PlaylistResponseDto {

    private Long id;
    private String title;
    private Set<SongDto> songs;


    @Builder
    public PlaylistResponseDto(Playlist playlist){
        this.id = playlist.getId();
        this.title = playlist.getTitle();

        if (playlist.getMusicSet() != null) {
            this.songs = playlist.getMusicSet().stream().map(song -> new SongDto(song, false)).collect(Collectors.toSet());
        }
    }
}
