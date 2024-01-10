package com.musi.shop.web.entity.playlist;

import com.musi.shop.web.dto.song.SongDto;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.comment.Comment;
import com.musi.shop.web.entity.song.Song;
import com.musi.shop.web.entity.time.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "Playlist")
public class Playlist extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="playlist_Id")
    private Long id;

    private String title;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Column
    @CreatedDate
    private LocalDateTime createDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> musicSet = new HashSet<>();


    // 수정
    public void update(String title) {
        this.title = title;

    }


}
