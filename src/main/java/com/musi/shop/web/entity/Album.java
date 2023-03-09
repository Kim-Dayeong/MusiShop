package com.musi.shop.web.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Album")
@Data
public class Album {

    //@Column(nullable = false, unique = true)

//    @GeneratedValue(generator = "USER_GENERATOR")
//    @GenericGenerator(name = "USER_GENERATOR",strategy = "uuid")
    @Id
    @Column
    private int id;

    @Column
    private String title;

    @Column
    private String artist;

    @Column
    private BigDecimal price;

    @Column
    private String img;

    @Column
    private String regdate;






}
