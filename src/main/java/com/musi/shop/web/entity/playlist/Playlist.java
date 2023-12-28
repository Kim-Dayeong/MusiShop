package com.musi.shop.web.entity.playlist;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.comment.Comment;
import com.musi.shop.web.entity.song.Song;
import com.musi.shop.web.entity.time.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name="playlist")
@Getter
@Setter
@NoArgsConstructor
public class Playlist extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="playlist_Id")
    private Long id;

    private int playIdex;

    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc ")
    private List<Song> songs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Column
    @CreatedDate
    private LocalDateTime createDate;

}
