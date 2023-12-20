package com.musi.shop.web.dto.community;


import com.musi.shop.web.dto.comment.CommentRequestDto;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.community.Community;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityResponseDto {

    private Long id;
    private String title;
    private String content;
    private Member member;
    private String nickname;
    private String username;
    private int view;
    private Channel channel;

    private List<CommentRequestDto> comments;

    @Builder
    public CommunityResponseDto(Community community){
        this.id = community.getId();
        this.title = community.getTitle();
        this.content = community.getContent();
        this.member = community.getMember();
        this.username = community.getMember().getUsername();
        this.nickname = community.getMember().getNickname();
        this.view = community.getView();

    }


}
