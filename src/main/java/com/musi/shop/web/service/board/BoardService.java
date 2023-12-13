package com.musi.shop.web.service.board;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.repository.board.BoardReporitory;
import com.musi.shop.web.repository.comment.CommentRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.dto.board.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor //생성자 주입
public class BoardService {

    @Autowired
    private BoardReporitory boardReporitory;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CommentRepository commentRepository;

    BoardResponseDto boardResponseDto;



    public Board createBoard(String title, String content, Long memberId) {
        // 회원 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회원이 존재하지 않습니다."));

        // 게시글 생성
        Board board = new Board(title, content, member);

        // 게시글 저장
        Board savedBoard = boardReporitory.save(board);

        // 게시글과 연관된 댓글 초기화 (댓글이 EAGER로 설정되어 있으므로 여기서 초기화)
        savedBoard.getComments().size();

        // 게시글과 연관된 이미지 초기화 (이미지가 필요하다면 활성화)
        // savedBoard.getImages().size();

        return savedBoard;

    }

    // 조회수
    @Transactional
    public int updateView(Long id){
        return boardReporitory.updateView(id);
    }

    //Read

    public BoardResponseDto BoardRead(Long id){
        Board board = boardReporitory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 없습니다. id : " + id));
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .member(board.getMember())
               // .comments(board.getComments())
                .build();
    }

}
