package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.Album;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AlbumResponseDto {

    private int albumid;
    private String title;
    private String name;
    private BigDecimal price;
    private String img;
    private String regdate;

    public AlbumResponseDto(Album entity){
        this.albumid = entity.getAlbumid();
        this.title = entity.getTitle();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.img = entity.getImg();
        this.regdate = entity.getRegdate();
    }
}
