package com.musi.shop.web.web.dto.album;

import com.musi.shop.web.web.dto.song.SongDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlbumSongRequest {

    private AlbumDto albumDto;
    private List<SongDto> songdtos;
}
