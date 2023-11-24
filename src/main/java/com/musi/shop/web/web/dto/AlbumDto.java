package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Heart;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.Song;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AlbumDto {

    private Long id;
    private String title;
    private String name;
    private BigDecimal price;
    private String img;
    private String regdate;
    private List<SongDto> songs;
    private List<HeartDto> hearts;


    public  AlbumDto (Album album){ //entity -> dto
        this.id = album.getId();
        this.title = album.getTitle();
        this.name = album.getName();
        this.price = album.getPrice();
        this.img = album.getImg();
        this.regdate = album.getRegdate();

        if (album.getSongs() != null){ // song 엔티티 리스트 -> songdto 리스트
            this.songs = album.getSongs().stream().map(SongDto::new).collect(Collectors.toList());
        }

        if (album.getHearts() != null) {
            this.hearts = album.getHearts().stream().map(HeartDto::new).collect(Collectors.toList());
        }
    }
}