package com.musi.shop.web.controller.board;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.time.BaseTimeEntity;
import com.musi.shop.web.service.board.BoardService;
import com.musi.shop.web.web.dto.album.AlbumDto;
import com.musi.shop.web.web.dto.board.BoardRequestDto;
import lombok.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Entity;


@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/board/read/{id}")
    public String read(@PathVariable Long id, Model model){
        BoardRequestDto dto = boardService.findById(id);
        boardService.updateView(id);
        model.addAttribute("boards", dto);

        return "/Board/board-read";
    }

    @GetMapping("/board/write")
    public String wirteBoard(Model model){
        BoardRequestDto boardRequestDto = new BoardRequestDto();
        model.addAttribute("boardDto", boardRequestDto);

        return "/Board/board-add.html";
    }

    @PostMapping("/board/write")
    public String writeBoardPost(@RequestBody BoardRequestDto boardRequestDto,
                                 @AuthenticationPrincipal PrincipalDetail principalDetail,
                                 Album album){
        boardRequestDto
    }

}
