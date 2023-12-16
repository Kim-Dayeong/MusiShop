package com.musi.shop.web.dto.board;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.dto.comment.CommentRequestDto;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private Member member;
    private String username;
    private String nickname;
    private int view;


    private List<CommentRequestDto> comments;

    public BoardResponseDto(Long id, String writerNickname, String title, String content) {
    } // 맞는건지 확인


    //Entity -> Dto
//    public static BoardResponseDto toDto (Board board, String writer_nickname) {
//        return new BoardResponseDto(
//
//                board.getId(),
//                writer_nickname,
//                board.getTitle(),
//                board.getContent()
//        );
//
//    }
//

    @Builder
    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.member = board.getMember();
        this.username = board.getMember().getUsername();
        this.nickname = board.getMember().getNickname();
        this.view = board.getView();

    }

}
