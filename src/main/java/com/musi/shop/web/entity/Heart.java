package com.musi.shop.web.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Data
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

    public void setAlbum(Album album) {
        this.album = album;
    }

    public static Heart toLike(Member member, Album album){
        Heart heart = new Heart();
        heart.setMember(member);
        heart.setAlbum(album);

        return heart;
    }



}
