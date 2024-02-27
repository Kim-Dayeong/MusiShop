package com.musi.shop.web.service.community;

import com.musi.shop.web.dto.board.BoardResponseDto;
import com.musi.shop.web.dto.channel.ChannelDto;
import com.musi.shop.web.dto.community.CommunityRequestDto;
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

    // view


    // list
    public Page<Community> communityList ( long id){
        Pageable pageable = PageRequest.of(0, 10);
        Optional<Community> communityOptional = communityRepository.findById(id);

        Community community = communityOptional.orElse(null);

        List<Community> communityList = new ArrayList<>();
        if(community != null){
            communityList.add(community);
        }
        return new PageImpl<Community>(communityList, pageable, communityList.size());
    }

    // write

//    public ChannelDto ChannelResponse(Long id){
//        Channel channel = channelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채널입니다."));
//       ChannelDto result = ChannelDto.builder()
//               .channel(channel)
//                .build();
//
//
//        return result;
//    }
}
