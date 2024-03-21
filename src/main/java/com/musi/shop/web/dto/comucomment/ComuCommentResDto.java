package com.musi.shop.web.dto.comucomment;

import com.musi.shop.web.entity.Comucomment.ComuComment;
import com.musi.shop.web.entity.comment.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ComuCommentResDto {

    private Long id;
    private String content;
    private String nickname;
    private String username;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public ComuCommentResDto(ComuComment comment){
        this.id = comment.getId();
        this.content = comment.getContent();
        this.nickname = comment.getMember().getNickname();
        this.username = comment.getMember().getUsername();
        this.createDate = comment.getCreateDate();
        this.modifiedDate = comment.getModifiedDate();

    }
}
