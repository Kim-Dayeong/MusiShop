package com.musi.shop.web.entity.song;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.entity.playlist.PlaylistSong;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Song")
@Getter
@Setter
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SONG_ID")
    private Long id;

    @Column(nullable = false)
    private String songname;

    @ManyToMany(mappedBy = "musicSet")
    private Set<Playlist> playlistSet = new HashSet<>();

    private int songdex;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ALBUM_ID", nullable = false)
    private Album album;

    public void updateAlbum(Album album) {
        this.album = album;
    }

    @Builder
    public Song(Long id, String songname, int songdex, Album album, Playlist playlist) {
        this.id = id;
        this.songname = songname;
        this.songdex = songdex;
        this.album = album;
    }



}
