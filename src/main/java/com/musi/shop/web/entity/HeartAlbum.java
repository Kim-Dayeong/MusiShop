package com.musi.shop.web.entity;


import lombok.*;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Builder
@Entity
public class HeartAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne( cascade = CascadeType.ALL)
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
