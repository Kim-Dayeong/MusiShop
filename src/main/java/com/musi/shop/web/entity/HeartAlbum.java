package com.musi.shop.web.entity;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Builder
@Entity(name = "HeartAlbum")
public class HeartAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "albumId")
    private Album album;

    @Column(nullable = false)
    private boolean status; // true = 좋아요, false = 좋아요 취소

    public HeartAlbum(Album album, Member member){
        this.album = album;
        this.member = member;
        this.status = true;
    }



    public void unHeartAlbum(Album album){
        this.status = false;
        album.setHeartcnt(album.getHeartcnt()-1);
    }

}
