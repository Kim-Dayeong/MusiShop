package com.musi.shop.web.entity;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity(name = "Like")
@NoArgsConstructor
@Getter

public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeId")
    private Long id;

//    private Boolean Like;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "albumId")
    private Album album;

    public void setAlbum(Album album) {
        this.album = album;
    }
}
