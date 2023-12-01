package com.musi.shop.web.entity;

import lombok.*;


import javax.persistence.*;

@Entity(name="Song")
@Getter
@Setter
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SONG_ID")
    private Long id;

    private String song_name;

   // private int albumid;

    private int songdex;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ALBUM_ID")
    private Album album;


    public void updateAlbum(Album album){
        this.album = album;
    }

    @Builder
    public Song(Long id, String song_name, int songdex,Album album){
        this.id = id;
        this.song_name = song_name;
        this.songdex = songdex;
        this.album = album;
    }



}
