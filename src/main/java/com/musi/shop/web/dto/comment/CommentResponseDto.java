package com.musi.shop.web.dto.comment;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private Long id;
    private String content;
    private String nickname;
    private String username;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public CommentResponseDto (Comment comment){
        this.id = comment.getId();
        this.content = comment.getContent();
        this.nickname = comment.getMember().getNickname();
        this.username = comment.getMember().getUsername();
        this.createDate = comment.getCreateDate();
        this.modifiedDate = comment.getModifiedDate();

    }

}
