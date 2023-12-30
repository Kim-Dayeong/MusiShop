package com.musi.shop.web.dto.playlist;

import com.musi.shop.web.dto.song.SongDto;
import com.musi.shop.web.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaylistRequestDto {

    private Long id;
    private String title;
    private Member member;
    private Set<SongDto> songs;



}
