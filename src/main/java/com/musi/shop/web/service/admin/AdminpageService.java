package com.musi.shop.web.service.admin;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.board.BoardReporitory;
import com.musi.shop.web.repository.channel.ChannelRepository;
import com.musi.shop.web.repository.comment.CommentRepository;
import com.musi.shop.web.repository.community.CommunityRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AdminpageService {

    private final MemberRepository memberRepository;
    private final AlbumRepository albumRepository;
    private final BoardReporitory boardReporitory;
    private final CommunityRepository communityRepository;


    // 앨범
    public Page<Album> albumList(Pageable pageable){ // 앨범 전체 목록 보기

            return albumRepository.findAll(pageable);

    }

    public void albumdelte(Long id){
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("앨범을 찾을 수 없습니다  : " + id));
        albumRepository.delete(album);

    }

    // 게시판
    public Page<Board> boardList(Pageable pageable){

        return boardReporitory.findAll(pageable);

    }

    public void boardDelte(Long id){

        Board board = boardReporitory.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("게시글을 찾을 수 없습니다." + id));
        boardReporitory.delete(board);

    }

    // 회원
    public  Page<Member> memberList(Pageable pageable){

        return memberRepository.findAll(pageable);

    }

    public void memberDelete(Long id){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다  : " + id));
        memberRepository.delete(member);

    }



    // 커뮤니티
    public  Page<Community> comunityList(Pageable pageable){

        return communityRepository.findAll(pageable);

    }

    public void communityDelete(Long id){
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("커뮤니티 글을 찾을 수 없습니다  : " + id));
        communityRepository.delete(community);

    }





}
