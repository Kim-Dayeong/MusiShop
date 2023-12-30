package com.musi.shop.web.dto.song;

import com.musi.shop.web.dto.album.AlbumDto;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.entity.song.Song;
import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SongPlayDto {
    private Long id;
    private String songname;
    private Playlist playlist;




}
