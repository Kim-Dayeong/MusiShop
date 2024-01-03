package com.musi.shop.web.entity.song;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.playlist.Playlist;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


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

    @Column(nullable = false)
    private String songname;


    private int songdex;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ALBUM_ID", nullable = false)
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_ID")
    private Playlist playlist;
    public void updateAlbum(Album album){
        this.album = album;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    @Builder
    public Song(Long id, String songname, int songdex,Album album, Playlist playlist){
        this.id = id;
        this.songname = songname;
        this.songdex = songdex;
        this.album = album;
        this.playlist = playlist;
    }



}
