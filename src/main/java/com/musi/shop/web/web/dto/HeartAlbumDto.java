package com.musi.shop.web.web.dto;


import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.HeartAlbum;
import com.musi.shop.web.entity.Member;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor

public class HeartAlbumDto {
    private Long id;
    private int memberId; // or private MemberDto member;
    private int albumId; // or private AlbumDto album;

    private boolean status;

    public HeartAlbumDto(Long id, int memberId, int albumId, boolean status) {
        this.id = id;
        this.memberId = memberId;
        this.albumId = albumId;
        this.status = status;
    }

    public HeartAlbum toEntity(Album album, Member member){
        return new HeartAlbum(album, member);
    }


}
