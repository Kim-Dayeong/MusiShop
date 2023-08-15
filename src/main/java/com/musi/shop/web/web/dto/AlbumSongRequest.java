package com.musi.shop.web.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlbumSongRequest {

    private AlbumDto albumDto;
    private List<SongDto> songdtos;
}
