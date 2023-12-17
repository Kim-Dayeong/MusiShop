package com.musi.shop.web.controller.board;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.board.BoardResponseDto;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.repository.board.BoardReporitory;
import com.musi.shop.web.service.board.BoardService;
import com.musi.shop.web.dto.board.BoardRequestDto;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BoardReporitory boardReporitory;

// Read
    @GetMapping("/board/read/{id}")
    public String read(@PathVariable Long id, Model model){
        BoardResponseDto dto = boardService.BoardDetail(id);
        boardService.updateView(id); // 조회수
        model.addAttribute("boards", dto);

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
    public ResponseEntity<Map<String, Object>>  deleteBoardPost(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetail principalDetail
    , RedirectAttributes redirectAttributes) {

        Map<String, Object> response = new HashMap<>();
        // 게시글 ID로 해당 게시글 가져오기
        Optional<Board> optionalBoard = boardReporitory.findById(id);

        // 게시글이 존재하지 않으면 에러 응답
        if (optionalBoard.isEmpty()) {
            response.put("success", false);
            response.put("message", "게시글이 존재하지 않습니다.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        // 로그인 안된 상태일때
        if (principalDetail == null || !principalDetail.isAccountNonExpired()) {
            response.put("success", false);
            response.put("message", "인증되지 않은 사용자입니다.");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        // 로그인한 사용자와 게시글 작성자가 다르면 권한 오류 응답
        Member boardMember = optionalBoard.get().getMember();
        if (boardMember == null || !Objects.equals(principalDetail.getUsername(), boardMember.getUsername())) {
            response.put("success", false);
            response.put("message", "해당 게시글에 대한 권한이 없습니다.");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }


        // 게시글 삭제
        boardService.deleteBoard(id);

        // 성공 응답
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
