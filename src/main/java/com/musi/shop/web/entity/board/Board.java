package com.musi.shop.web.entity.board;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.comment.Comment;
import com.musi.shop.web.entity.time.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "Board")
public class Board  extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc ") //댓글 정렬
    private List<Comment> comments;

    @Column
    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;


    // 이미지
//    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private List<Image> images;

    // 카테고리 - 아티스트 계정 생성시 생성되게

    @Column(nullable = true)
    private int liked; // 추천수

    @Column(nullable = true)
    private int bookmark; // 북마크 수

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view; // 조회수

    public Board(final String title,final String content, final Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.liked = 0;
        this.bookmark = 0;
    }

    //게시글 수정 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 추천 메서드

    // 북마크 메서드

}
