package com.musi.shop.web.dto.song;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.song.Song;
import com.musi.shop.web.dto.album.AlbumDto;
import groovy.transform.builder.Builder;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@Builder
public class SongDto {

    private Long id;
    private String song_name;
    private int songdex;

    private Album album;
    private AlbumDto albumdto;



    public SongDto(Song song) { // 엔터티 -> DTO
        this.id = song.getId();
        this.song_name = song.getSong_name();
        this.songdex = song.getSongdex();

        //albumdto 대신 album엔티티의 일부만
        if (song.getAlbum() != null){
            this.albumdto = new AlbumDto(song.getAlbum());
        }
    }

//    @Builder
//    public SongDto(Long id, String song_name, int songdex, Album album){
//        this.id = id;
//        this.song_name = song_name;
//        this.songdex = songdex;
//        this.album = album;
//    }
//

    //dto -> entity
    public Song toEntity() {
        Song songs = Song.builder()
                .id(id)
                .song_name(song_name)
                .songdex(songdex)
               .album(album)
                .build();
        return songs;
    }

    // AlbumDto 대신 Album 엔터티의 일부 정보만 담도록 변경
    public static SongDto newWithoutAlbum(Song song) {
        SongDto songDto = new SongDto();
        songDto.setId(song.getId());
        songDto.setSong_name(song.getSong_name());
        songDto.setSongdex(song.getSongdex());
        return songDto;
    }

}
