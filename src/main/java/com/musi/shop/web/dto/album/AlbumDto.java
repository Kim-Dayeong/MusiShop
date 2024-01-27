package com.musi.shop.web.dto.album;

import com.musi.shop.web.dto.heart.HeartDto;
import com.musi.shop.web.dto.song.SongDto;
import com.musi.shop.web.entity.album.Album;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {

    private Long id;
    private String title;
    private String name;
    private BigDecimal price;
//    private String img;
    private String regdate;
    private Long heartcnt;
    private List<SongDto> songs;
    private List<HeartDto> hearts;
    private int view;


    public  AlbumDto (Album album){ //entity -> dto
        this.id = album.getId();
        this.title = album.getTitle();
        this.name = album.getName();
        this.price = album.getPrice();
//        this.img = album.getImg();
        this.regdate = album.getRegdate();
        this.heartcnt = album.getHeartcnt();
        this.view = album.getView();

        if (album.getSongs() != null) {
            this.songs = album.getSongs().stream().map(song -> new SongDto(song, false)).collect(Collectors.toList());
        }


//        if (album.getHearts() != null) {
//            this.hearts = album.getHearts().stream().map(HeartDto::new).collect(Collectors.toList());
//        }
    }
}