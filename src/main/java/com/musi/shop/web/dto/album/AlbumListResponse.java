package com.musi.shop.web.dto.album;

import com.musi.shop.web.entity.album.Album;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor

@Getter
@Setter
public class AlbumListResponse { //전체 게시글 보내기

    private Long id;
    private String name;
    private BigDecimal price;
    private String img;
    private String regdate;
    private String title;

    public Album toEntity() {
        Album build = Album.builder()
                .id(id)
                .name(name)
                .price(price)
                .title(title)
                .regdate(regdate)
                .build();
        return build;
    }

    @Builder
    public AlbumListResponse(Long id, String name, BigDecimal price, String img, String regdate, String title){
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.regdate = regdate;
        this.title = title;

    }


}
