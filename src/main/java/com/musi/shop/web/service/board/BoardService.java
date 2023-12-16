package com.musi.shop.web.service.board;

import com.musi.shop.web.dto.board.BoardRequestDto;
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
import java.util.Optional;

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





    public void createBoard(BoardRequestDto boardRequestDto, String username, String nickname, Board board) {

        //String title, String content, Long memberId

        board.setId(boardRequestDto.getId());
        //board.setMember(boardRequestDto.getMember());
        board.setContent(boardRequestDto.getContent());
        board.setTitle(boardRequestDto.getTitle());


        Optional<Member> memberOptional = memberRepository.findByUsername(username); //username으로 member 검색
        Member member = memberOptional.orElseThrow(() -> new IllegalArgumentException());
        board.setMember(member);


       // board.setCreateDate(boardRequestDto.getCreateDate());
       // board.setBookmark(board.getBookmark());
        //board.setLiked(board.getLiked());
        //board.setView(board.getView());
       // board.setComments(board.setComments());

        // 게시글 저장
        Board savedBoard = boardReporitory.save(board);

        // 게시글과 연관된 댓글 초기화 (댓글이 EAGER로 설정되어 있으므로 여기서 초기화)
        //savedBoard.getComments().size();

        // 게시글과 연관된 이미지 초기화 (이미지가 필요하다면 활성화)
        // savedBoard.getImages().size();

    }

    // 조회수
    @Transactional
    public int updateView(Long id){
        return boardReporitory.updateView(id);
    }

    //Read
//    public BoardResponseDto BoardRead(Long id){
//        Board board = boardReporitory.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("게시글이 없습니다. id : " + id));
//       Member member = board.getMember();
//        return BoardResponseDto
//
//
//    }

    public BoardResponseDto BoardDetail(Long id){
        Board board = boardReporitory.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        BoardResponseDto result = BoardResponseDto.builder()
                .board(board)
                .build();

        return result;
    }

    // Update

    public Long updateBoard(Long id, BoardRequestDto boardRequestDto){
        Board board = boardReporitory.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
       board.update(boardRequestDto.getTitle(), boardRequestDto.getContent());
    boardReporitory.save(board);
        return board.getId();
    }

    // Delete
    public void deleteBoard(Long id){
        Board board = boardReporitory.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        boardReporitory.delete(board);
    }

}
