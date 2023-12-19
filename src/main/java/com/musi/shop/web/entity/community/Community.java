package com.musi.shop.web.entity.community;


import com.musi.shop.web.entity.Member;

import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.comment.Comment;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Community")
public class Community {

    @Id
    @Column(name = "comu_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(mappedBy = "community",fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_Id")
    private Channel channel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

//    @OneToMany(mappedBy = "community", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @OrderBy("id asc ") //댓글 정렬
//    private List<Comment> comments;

    @Column
    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    // 이미지
//    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private List<Image> images;

    @Column(nullable = true)
    private int liked; // 추천수

    @Column(nullable = true)
    private int bookmark; // 북마크 수

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view; // 조회수

    public Community(final String title,final String content, final Channel channel, final Member member) {
        this.title = title;
        this.content = content;
        this.channel = channel;
        this.member = member;
        this.liked = 0;
        this.bookmark = 0;
    }

}
