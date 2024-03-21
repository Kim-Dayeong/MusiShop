package com.musi.shop.web.entity.channel;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.comment.Comment;
import com.musi.shop.web.entity.community.Community;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "Channel")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_Id")
    private Long id;


    @OneToOne(mappedBy = "channel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Community> communities = new ArrayList<>();

}