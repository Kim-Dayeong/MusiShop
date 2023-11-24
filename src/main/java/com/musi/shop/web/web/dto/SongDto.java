package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Song;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class SongDto {

    private Long id;
    private String song_name;
    private int songdex;

    private AlbumSongDto album;



    public SongDto(Song song) { // 엔터티 -> DTO
        this.id = song.getId();
        this.song_name = song.getSong_name();
        this.songdex = song.getSongdex();
        this.album = new AlbumSongDto(song.getAlbum());
    }





//    @Builder
//    public SongDto(Long id, String song_name, int songdex, Album album){
//        this.id = id;
//        this.song_name = song_name;
//        this.songdex = songdex;
//        this.album = album;
//    }
//
    public Song toEntity() {
        Song build = Song.builder()
                .id(id)
                .song_name(song_name)
                .songdex(songdex)
               .album(album)
                .build();
        return build;
    }

}
