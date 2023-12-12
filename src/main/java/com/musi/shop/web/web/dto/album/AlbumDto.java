package com.musi.shop.web.web.dto.album;

import com.musi.shop.web.entity.album.Album;

import com.musi.shop.web.web.dto.heart.HeartDto;
import com.musi.shop.web.web.dto.song.SongDto;
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
    private String img;
    private String regdate;
    private Long heartcnt;
    private List<SongDto> songs;
    private List<HeartDto> hearts;


    public  AlbumDto (Album album){ //entity -> dto
        this.id = album.getId();
        this.title = album.getTitle();
        this.name = album.getName();
        this.price = album.getPrice();
        this.img = album.getImg();
        this.regdate = album.getRegdate();
        this.heartcnt = album.getHeartcnt();

        if (album.getSongs() != null){ // song 엔티티 리스트 -> songdto 리스트
            this.songs = album.getSongs().stream().map(SongDto::new).collect(Collectors.toList());
        }

//        if (album.getHearts() != null) {
//            this.hearts = album.getHearts().stream().map(HeartDto::new).collect(Collectors.toList());
//        }
    }
}