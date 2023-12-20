package com.musi.shop.web.dto.community;


import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.community.Community;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityRequestDto {

    private Long id;
    private String title;
    private String content;
    private Channel channel;


    //dto -> entity
    public Community toEntity() {
        Community community  = Community.builder()
                .id(id)
                .content(content)
                .title(title)
                .channel(channel)
                .build();

        return community;
    }
}
