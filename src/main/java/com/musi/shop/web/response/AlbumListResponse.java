package com.musi.shop.web.response;

import com.musi.shop.web.entity.Album;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor

@Getter
@Setter
public class AlbumListResponse { //전체 게시글 보내기

    private int albumid;
    private String name;
    private BigDecimal price;
    private String img;
    private String regdate;
    private String title;

    public Album toEntity() {
        Album build = Album.builder()
                .albumid(albumid)
                .name(name)
                .price(price)
                .title(title)
                .regdate(regdate)
                .build();
        return build;
    }

    @Builder
    public AlbumListResponse(int albumid, String name, BigDecimal price, String img, String regdate, String title){
        this.albumid = albumid;
        this.name = name;
        this.price = price;
        this.img = img;
        this.regdate = regdate;
        this.title = title;

    }


}
