package com.musi.shop.web.entity.playlist;

import com.musi.shop.web.entity.song.Song;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="playlistsong")
@Getter
@Setter
@NoArgsConstructor
public class PlaylistSong {

    @Id
    @Column(name = "playsong_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_Id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "SONG_ID")
    private Song song;

    public PlaylistSong(Playlist playlist, Song song) {
        this.playlist = playlist;
        this.song = song;
    }




}
