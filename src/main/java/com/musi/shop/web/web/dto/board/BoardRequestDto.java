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
public class BoardRequestDto {

    private Long id;
    private String title;
    private String content;
    private Member member;
    private List<CommentRequestDto> comments;

    //dto -> entity
    public Board toEntity() {
        Board board = Board.builder()
                .id(id)
                .content(content)
                //.createDate(createDate)
               // .modifiedDate
                .member(member)
                .build();

        return board;
    }

}
