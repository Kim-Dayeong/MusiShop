package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Song;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class SongDto {

    private Long id;
    private String song_name;

    private int songdex;

    private Album album;

    @Builder
    public SongDto(Long id, String song_name, int songdex, Album album){
        this.id = id;
        this.song_name = song_name;
        this.songdex = songdex;
        this.album = album;
    }

    public Song toEntity() {
        Song build = Song.builder()
               // .id(id)
                .song_name(song_name)
                .songdex(songdex)
                .album(album)
                .build();
        return build;
    }

}
