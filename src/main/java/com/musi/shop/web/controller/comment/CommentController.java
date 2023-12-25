package com.musi.shop.web.controller.comment;


import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.comment.CommentRequestDto;
import com.musi.shop.web.service.comment.CommentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // read


    // write

    @PostMapping("/board/{id}/comment")
    public String writeComment(@PathVariable Long id, CommentRequestDto commentRequestDto,
                               @AuthenticationPrincipal PrincipalDetail principalDetail){
        commentService.writeComment(commentRequestDto, id, principalDetail);
        return "redirect:/board/read/" + id;
    }


    // modify


    // delete
}
