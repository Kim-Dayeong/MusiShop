package com.musi.shop.web.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Column(name = "albumId")
    private Long id;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int heartcnt;


    @Column
    private String name; //member의 nickname

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId") // db에 user_id 컬럼명
    private Member member;

    @OneToMany(mappedBy = "album",fetch = FetchType.EAGER)
    private Set<Heart> hearts = new HashSet<>();


    @OneToMany(mappedBy = "album",fetch = FetchType.EAGER)
    @OrderBy("songdex asc")
    private Set<Song> songs = new HashSet<>();


    @Column
    private BigDecimal price;

    @Column
    private String img;

    @Column
    private String regdate;



    @Builder
    public Album(Long id,String title, String name, BigDecimal price, String img, String regdate , int heartcnt){
        this.id = id;
        this.title = title;
        this.name = name;
        this.price = price;
        this.regdate = regdate;
        this.img = img;
        this.heartcnt = heartcnt;

    }





}
