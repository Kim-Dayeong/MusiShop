package com.musi.shop.web.dto.playlist;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.playlist.Playlist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaylistCreateDto {

    private Long id;
    private String title;
    private Member member;
    private LocalDateTime createDate;


    //dto -> entity
    public Playlist toEntity() {
        Playlist playlist = Playlist.builder()
                .id(id)
                .title(title)
                .member(member)
                .createDate(createDate)
                .build();

        return playlist;
    }
}
