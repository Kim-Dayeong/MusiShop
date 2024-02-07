package com.musi.shop.web.entity.album;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.channel.Channel;

import com.musi.shop.web.entity.song.Song;
import com.musi.shop.web.entity.time.BaseTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Album")
@Getter
@Setter
public class Album extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "albumId")
    private Long id;

    @Column
    private Long heartcnt;


    @Column
    private String name; //member의 nickname

    @Column
    private String title;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId") // db에 user_id 컬럼명
//    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "channel_Id")
    private Channel channel;

//    @OneToMany(mappedBy = "album",fetch = FetchType.LAZY)
//    private Set<Heart> hearts = new HashSet<>();


    @OneToMany(mappedBy = "album",fetch = FetchType.LAZY,  cascade = CascadeType.REMOVE)
    @OrderBy("songdex asc") // 정렬
    private List<Song> songs = new ArrayList<>();

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view; // 조회수


    @Column
    private BigDecimal price;

    @Column
    private String img;

    @Column
    private String regdate;

    @Column
    @CreatedDate
    private LocalDateTime createdate;





    @Builder
    public Album(Long id,String title, int view, String name, BigDecimal price, String img, String regdate , long heartcnt){
        this.id = id;
        this.title = title;
        this.name = name;
        this.price = price;
        this.regdate = regdate;
        this.img = img;
        this.view = view;
        this.heartcnt = heartcnt;

    }



}
