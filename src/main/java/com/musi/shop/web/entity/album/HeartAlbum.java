package com.musi.shop.web.entity.album;


import com.musi.shop.web.entity.Member;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Builder
@Entity(name = "HeartAlbum")
public class HeartAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "albumId")
    private Album album;


    public HeartAlbum(Album album, Member member){
        this.album = album;
        this.member = member;

    }



    public void unHeartAlbum(Album album){
//        this.status = false;
        album.setHeartcnt(album.getHeartcnt()-1);
    }

}
