package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.Album;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AlbumDto {

    private Long id;
    private String title;
    private String name;
    private BigDecimal price;
    private String img;
    private String regdate;
    private List<SongDto> songs;



    public Album toEntity() {
        Album build = Album.builder()
                .id(id)
                .title(title)
                .name(name)
                .regdate(regdate)
                .price(price)
                .img(img)
                .build();
                return build;
    }

    @Builder
    public AlbumDto(Long id,String title, String name, BigDecimal price, String img, String regdate, List<SongDto> songs){
        this.id = id;
        this.title = title;
        this.name = name;
        this.price = price;
        this.regdate = regdate;
        this.img = img;
        this.songs = songs;
    }

}
