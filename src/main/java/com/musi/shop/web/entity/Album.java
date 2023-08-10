package com.musi.shop.web.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Album")
@Getter
@Data
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALBUM_ID")
    private Long id;

    @Column
    private String title;

    @Column
    private String name;

    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();


    @Column
    private BigDecimal price;

    @Column
    private String img;

    @Column
    private String regdate;



    @Builder
    public Album(Long id,String title, String name, BigDecimal price, String img, String regdate){
        this.id = id;
        this.title = title;
        this.name = name;
        this.price = price;
        this.regdate = regdate;
        this.img = img;
    }





}
