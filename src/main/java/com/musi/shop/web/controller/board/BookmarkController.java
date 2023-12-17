package com.musi.shop.web.controller.board;


import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.service.board.BoardService;
import com.musi.shop.web.service.board.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BookmarkController {

    private final BoardService boardService;
    private final BookmarkService bookmarkService;

    @GetMapping("/board/bookmark/{id}")
    public boolean bookmark(@PathVariable("id") Long id,
                            @AuthenticationPrincipal PrincipalDetail principalDetail) {

        Board board = bookmarkService.findBoard(id);
        Member member = bookmarkService.findMember(principalDetail.getUsername());
//       boolean success = bookmarkService.bookmarking(board,member);
//        if (success) {
//            return new ResponseEntity<>("{\"success\": true}", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("{\"success\": false}", HttpStatus.OK);
//        }

        return bookmarkService.bookmarking(board,member);
    }

}
