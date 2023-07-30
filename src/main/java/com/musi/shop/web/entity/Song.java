package com.musi.shop.web.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int song_id;

    private String song_name;

    private int albumid;

    private int songdex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "albumid")
    private Album album;

    public Song(String song_name){
        this.song_name = song_name;
    }

    public void updateAlbum(Album album){
        this.album = album;
    }



}
