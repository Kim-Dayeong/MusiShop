package com.musi.shop.web.response;

import com.musi.shop.web.entity.Album;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor

@Getter
@Setter
public class AlbumListResponse { //전체 게시글 보내기

    private int id;
    private String artist;
    private BigDecimal price;
    private String img;
    private String regdate;
    private String title;

    public Album toEntity() {
        Album build = Album.builder()
                .id(id)
                .artist(artist)
                .price(price)
                .title(title)
                .regdate(regdate)
                .build();
        return build;
    }

    @Builder
    public AlbumListResponse(int id, String artist, BigDecimal price, String img, String regdate, String title){
        this.id = id;
        this.artist = artist;
        this.price = price;
        this.img = img;
        this.regdate = regdate;
        this.title = title;

    }


}
