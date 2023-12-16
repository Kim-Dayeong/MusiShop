package com.musi.shop.web.controller.board;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.board.BoardResponseDto;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.service.board.BoardService;
import com.musi.shop.web.dto.board.BoardRequestDto;
import lombok.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

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

        String username = principalDetail.getUsername();
        String nickname = principalDetail.getName();
        boardService.createBoard(boardRequestDto,username, nickname, board);

        return "redirect:/";
    }

    // update
    @GetMapping("/board/update/{id}")
    public String updateBoardGet(@PathVariable Long id, Model model,
                                 @AuthenticationPrincipal PrincipalDetail principalDetail ){


        // 유저 인증
//        UserDetails userDetails = (UserDetails) principalDetail.getAuthorities();
//
//        if(result.getUsername() != userDetails.getUsername()) {
//            return "redirect:/";
//        }

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
    public String deleteBoardPost(@PathVariable Long id){

        boardService.deleteBoard(id);

        return "redirect:/";
    }


}
