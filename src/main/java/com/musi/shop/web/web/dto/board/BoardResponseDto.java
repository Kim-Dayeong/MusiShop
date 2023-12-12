package com.musi.shop.web.web.dto.board;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.web.dto.comment.CommentRequestDto;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private Member member;
    private List<CommentRequestDto> comments;

    //Entity -> Dto
    public BoardResponseDto (Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();

    }
}
