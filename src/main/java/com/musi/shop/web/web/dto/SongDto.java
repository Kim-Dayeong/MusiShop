package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Song;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class SongDto {

    private Long id;
    private String song_name;

    private int songdex;

    private Album album;

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
