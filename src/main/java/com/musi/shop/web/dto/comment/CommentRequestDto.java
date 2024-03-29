package com.musi.shop.web.dto.comment;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {

    private Long id;
    private String content;

    private Board board;

    // dto -> entity
    public Comment toEntity() {
        Comment comment = Comment.builder()
                .id(id)
                .content(content)
                .board(board)
                .build();

        return comment;
    }




}
