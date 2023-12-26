package com.musi.shop.web.service.comment;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.board.BoardResponseDto;
import com.musi.shop.web.dto.comment.CommentRequestDto;
import com.musi.shop.web.dto.comment.CommentResponseDto;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.comment.Comment;
import com.musi.shop.web.repository.board.BoardReporitory;
import com.musi.shop.web.repository.comment.CommentRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final MemberRepository memberRepository;
    private final BoardReporitory boardReporitory;
    private final CommentRepository commentRepository;

    // write

    public Long writeComment(CommentRequestDto commentRequestDto, Long boardId,
                             @AuthenticationPrincipal PrincipalDetail principalDetail
                             ){
        Optional<Member> memberOptional = memberRepository.findByUsername(principalDetail.getUsername());
        Member member = memberOptional.orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 존재하지 않습니다."));
        Board board = boardReporitory.findById(boardId).orElseThrow(()-> new IllegalArgumentException("게시물을 찾을수 없습니다."));
        Comment result = Comment.builder()
                .content(commentRequestDto.getContent())
                .board(board)
                .member(member)
                .build();
        commentRepository.save(result);
        return result.getId();
    }

    // read
    public List<CommentResponseDto>  readComment(Long BoardId){ //boardId로 comment 읽어오기
        List<Comment> comments = commentRepository.findByBoardId(BoardId);

       return comments.stream() .map(comment -> CommentResponseDto.builder()
               .comment(comment)
               .build())
               .collect(Collectors.toList());
    }


    // modify



    // delete
}
