package com.musi.shop.web.dto.board;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.dto.comment.CommentRequestDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BoardRequestDto { //create

    private Long id;
    private String title;
    private String content;
   // private Member member;
   // private List<CommentRequestDto> comments;

    //dto -> entity
    public Board toEntity() {
        Board board = Board.builder()
                .id(id)
                .content(content)
                .title(title)
                //.createDate(createDate)
               // .modifiedDate
               // .member(member)
                .build();

        return board;
    }

}
