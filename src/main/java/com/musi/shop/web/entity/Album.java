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
@Data
public class Album {

    //@Column(nullable = false, unique = true)

//    @GeneratedValue(generator = "USER_GENERATOR")
//    @GenericGenerator(name = "USER_GENERATOR",strategy = "uuid")
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

//    public void addSong(Song song){
//        this.songs.add(song);
//        song.updateAlbum(this);
//    }

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
