package com.musi.shop.web.service.member;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.Role;
import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.dto.album.AlbumDto;
import com.musi.shop.web.repository.channel.ChannelRepository;
import com.musi.shop.web.repository.community.CommunityRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor //생성자 주입
public class MemberService {

    @Autowired
    private final AlbumRepository albumRepository;
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final ChannelRepository channelRepository;

    @Autowired
    private final CommunityRepository communityRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    // 아티스트 유저 회원가입
    public void ArtMemberJoin(Member member){

        String rawPassword = member.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        member.setPassword(encPassword);
        member.setRole(Role.ARTIST);
            Channel channel = new Channel(); // 아티스트 유저 채널 생성
            channel.setMember(member);
            member.setChannel(channel);

            channelRepository.save(channel);
            memberRepository.save(member);


        }


    //앨범 제목,커버 받아오기
    @Transactional
    public AlbumDto getAlbumtitle(Long channelId) {

        List<Album> albums = albumRepository.findAlbumByChannelId(channelId);

        //앨범에서 title , image 받아서 내보내기
        List<AlbumDto> albumDtos =
                albums.stream()
                .map(album -> {
                    AlbumDto albumDto = new AlbumDto();
                    albumDto.setTitle(album.getTitle());
//                    albumDto.setImg(album.getImg());
                    albumDto.setId(album.getId());
                    return albumDto;
                })
                .collect(Collectors.toList());

        //AlbumDto 목록을 AlbumDto 객체로 묶어서 반환
        AlbumDto albumlist = new AlbumDto();
//       albumlist.setAlbumsList(albumDtos);
       return albumlist;
    }

    // 회원 탈퇴
    public void userExit(String username){
        Optional<Member> memberOptional = memberRepository.findByUsername(username);
        Member member = memberOptional.orElseThrow(() -> new IllegalArgumentException());

        memberRepository.delete(member);

    }

    // 회원수정
    public void userupdate(String username){
        Optional<Member> memberOptional = memberRepository.findByUsername(username);
        Member member = memberOptional.orElseThrow(() -> new IllegalArgumentException());


    }

}
