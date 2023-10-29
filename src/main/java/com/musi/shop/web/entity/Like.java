package com.musi.shop.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Like")
@NoArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean Like;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Member member;

}
