package com.musi.shop.web.service.comument;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.comment.CommentRequestDto;
import com.musi.shop.web.dto.comucomment.ComuCommentReqDto;
import com.musi.shop.web.dto.comucomment.ComuCommentResDto;
import com.musi.shop.web.entity.Comucomment.ComuComment;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.repository.community.CommunityRepository;
import com.musi.shop.web.repository.comucomment.ComucommentRepositroy;
import com.musi.shop.web.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommumentService {

    private final MemberRepository memberRepository;
    private final ComucommentRepositroy  comucommentRepositroy;
    private final CommunityRepository communityRepository;


    // write
    public Long writeComment(ComuCommentReqDto comuCommentReqDto, Long comuid,
                             @AuthenticationPrincipal PrincipalDetail principalDetail
    ) {

        Optional<Member> memberOptional = memberRepository.findByUsername(principalDetail.getUsername());
        Member member = memberOptional.orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 존재하지 않습니다."));
        Community community = communityRepository.findById(comuid).orElseThrow(()-> new IllegalArgumentException("게시물을 찾을수 없습니다."));
        ComuComment result = ComuComment.builder()
                .content(comuCommentReqDto.getContent())
                .community(community)
                .member(member)
                .build();
        comucommentRepositroy.save(result);
        return result.getId();
    }


    // read
    public List<ComuCommentResDto> readComment(Long CommuId){
        List<ComuComment> comments = comucommentRepositroy.findByCommunityId(CommuId);

        return comments.stream()
                .map(comuComment -> ComuCommentResDto.builder()
                        .comment(comuComment)
                        .build())
                .collect(Collectors.toList());
    }

}


