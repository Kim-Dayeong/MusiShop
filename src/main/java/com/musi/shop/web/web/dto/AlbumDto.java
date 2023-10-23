package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Member;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AlbumDto {

    private Long id;
    private String title;
    //private String name;
    private BigDecimal price;
    private String img;
    private String regdate;
    private List<SongDto> songs;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private Member member;




    public Album toEntity() {
        Album build = Album.builder()
                .id(id)
                .title(title)
               // .name(name)
                .regdate(regdate)
                .price(price)
                .img(img)
                .member(member)
                .build();
        return build;
    }

    @Builder
    public AlbumDto(Long id, String title,  BigDecimal price, String img, String regdate, List<SongDto> songs, Member member){
        this.id = id;
        this.title = title;
      //  this.name = name;
        this.price = price;
        this.regdate = regdate;
        this.img = img;
        this.songs = songs;
        this.member = member;

    }

}