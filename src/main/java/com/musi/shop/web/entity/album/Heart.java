package com.musi.shop.web.entity.album;

import com.musi.shop.web.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity(name = "Heart")
@NoArgsConstructor
@Getter
@Setter

public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heartId")
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Member member;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "albumId")
    private Album album;

    @Column(nullable = false)
    private boolean status; //true = 추가 , false = 취소

//    public void setAlbum(Album album) {
//        this.album = album;
//    }
//
//    public static Heart toLike(Member member, Album album){
//        Heart heart = new Heart();
//        heart.setMember(member);
//        heart.setAlbum(album);
//
//        return heart;
//    }

public Heart(Album album, Member member){
    this.album = album;
    this.member = member;
    this.status = true;
}

public void unHeartAlbum(Album album){
    this.status = false;
    album.setHeartcnt(album.getHeartcnt()-1);
}
}
