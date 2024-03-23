package com.musi.shop.web.service.community;

import com.musi.shop.web.dto.board.BoardResponseDto;
import com.musi.shop.web.dto.channel.ChannelDto;
import com.musi.shop.web.dto.community.CommunityRequestDto;
import com.musi.shop.web.dto.community.CommunityResponseDto;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.repository.channel.ChannelRepository;
import com.musi.shop.web.repository.community.CommunityRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor //생성자 주입
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ChannelRepository channelRepository;

    // write
    public void createCommunity(CommunityRequestDto communityRequestDto, String username,
                                Community community,Long id ){

        community.setId(communityRequestDto.getId());
        community.setContent(communityRequestDto.getContent());
        community.setTitle(communityRequestDto.getTitle());

        Optional<Member> memberOptional = memberRepository.findByUsername(username); // username으로 member 검색
        Member member = memberOptional.orElseThrow(() -> new IllegalArgumentException());
        community.setMember(member);

        Optional<Channel> channelOptional = channelRepository.findById(id); // id로 채널 검색
        Channel channel = channelOptional.orElseThrow(()-> new IllegalArgumentException());
        community.setChannel(channel);

        communityRepository.save(community);

    }

    // read
    public CommunityResponseDto CommunityDetail(Long id){
        Community community = communityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        CommunityResponseDto result = CommunityResponseDto.builder()
                .community(community)
                .build();

        return result;
    }





    //페이징
    public Page<Community> commuList(Pageable pageable, long id) {
        return communityRepository.findByChannel_Id(id,pageable);
    }


}
