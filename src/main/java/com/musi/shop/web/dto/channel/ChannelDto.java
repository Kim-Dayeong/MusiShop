package com.musi.shop.web.dto.channel;


import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.community.Community;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDto {

    private  Long id;
    private Member member;
    private Community community;


    @Builder
    public ChannelDto(Channel channel) {
        this.id = channel.getId();
        this.member = channel.getMember();


    }

}
