package com.musi.shop.web.controller.board;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.ResponseDto;
import com.musi.shop.web.dto.board.BoardResponseDto;
import com.musi.shop.web.dto.comment.CommentResponseDto;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.repository.board.BoardReporitory;
import com.musi.shop.web.service.board.BoardService;
import com.musi.shop.web.dto.board.BoardRequestDto;
import com.musi.shop.web.service.board.BookmarkService;
import com.musi.shop.web.service.comment.CommentService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BookmarkService bookmarkService;
    private final CommentService commentService;

    @Autowired
    private BoardReporitory boardReporitory;

// Read
    @GetMapping("/board/read/{id}")
    public String read(@PathVariable Long id, Model model){
        BoardResponseDto dto = boardService.BoardDetail(id);
        CommentResponseDto commentdto = commentService.
        boardService.updateView(id); // 조회수
        model.addAttribute("boards", dto);
        model.addAttribute("comments",);

        return "/board/board-read";
    }

    @GetMapping("/board/write")
    public String wirteBoard(Model model){
        BoardRequestDto boardRequestDto = new BoardRequestDto();
        model.addAttribute("boardDto", boardRequestDto);

        return "/board/board-add.html";
    }

    @PostMapping("/board/write")
    public String writeBoardPost(@ModelAttribute BoardRequestDto boardRequestDto,
                                 @AuthenticationPrincipal PrincipalDetail principalDetail,
                                 Board board){
        boardService.createBoard(boardRequestDto,principalDetail.getUsername(), board);

        return "redirect:/";
    }

    // update
    @GetMapping("/board/update/{id}")
    public String updateBoardGet(@PathVariable Long id, Model model,
                                 @AuthenticationPrincipal PrincipalDetail principalDetail ){

        BoardResponseDto result = boardService.BoardDetail(id);
        model.addAttribute("result", result);
        model.addAttribute("id", id);

        return "/board/board-update";
    }

    @PostMapping("/board/update/{id}")
    public String updateBoardPost(@PathVariable Long id, BoardRequestDto boardRequestDto){

        boardService.updateBoard(id, boardRequestDto);

        return "/board/board-read";
    }

    // Delete
    @GetMapping("/board/delete/{id}")
    @ResponseBody
    public ResponseDto<?> deleteBoardPost(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetail principalDetail
    ) {

        Integer statusCode = HttpStatus.OK.value();

        // 게시글 ID로 해당 게시글 가져오기
        Optional<Board> optionalBoard = boardReporitory.findById(id);

        // 게시글이 존재하지 않으면 에러 응답
        if (optionalBoard.isEmpty()) {

            return new ResponseDto<>(-1, "게시글이 존재하지 않습니다", null);
        }

        // 로그인 안된 상태일때
        if (principalDetail == null || !principalDetail.isAccountNonExpired()) {
            return new ResponseDto<>(-1, "인증되지 않은 사용자 입니다", null);
        }

        // 로그인한 사용자와 게시글 작성자가 다르면 권한 오류 응답
        Member boardMember = optionalBoard.get().getMember();
        if (boardMember == null || !Objects.equals(principalDetail.getUsername(), boardMember.getUsername())) {
            return new ResponseDto<>(-1, "작성자 아이디가 일치하지 않습니다", null);
        }

        // 게시글 삭제
        boardService.deleteBoard(id);
        return new ResponseDto<>(1,"삭제되었습니다", true);

    }

    // 페이징
    @GetMapping("/board/list")
    public String albumList(Model model, @PageableDefault(page = 0, size = 10, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){


        Page<Board> list = boardService.boardList(pageable);

        //페이지 블럭 처리
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage -3, 1);
        int endPage = Math.min(nowPage + 3, list.getTotalPages());
        int starttotal = 0;
        int endtotal = list.getTotalPages()-1;

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("starttotal", starttotal);
        model.addAttribute("endtotal", endtotal);

        return "board/board-list";
    }

    @GetMapping("/board/bookmark/{id}")
    @ResponseBody
    public  ResponseDto<?> bookmark(@PathVariable("id") Long id,
                            @AuthenticationPrincipal PrincipalDetail principalDetail) {

        Board board = bookmarkService.findBoard(id);
        Member member = bookmarkService.findMember(principalDetail.getUsername());

        if (bookmarkService.bookmarking(board,member)){ // true
            return new ResponseDto<>(1, "북마크 추가 되었습니다", true);
        }
        return new ResponseDto<>(1, "북마크 해제 되었습니다", false);

    }

}


