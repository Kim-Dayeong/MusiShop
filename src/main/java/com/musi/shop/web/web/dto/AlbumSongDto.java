package com.musi.shop.web.web.dto;


import com.musi.shop.web.entity.Album;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumSongDto {

    private Long id;

    public AlbumSongDto(Album album){
        this.id = album.getId();
    }
}
