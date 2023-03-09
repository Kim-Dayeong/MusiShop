package com.musi.shop.web.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="User")
@Data
public class User {

    @Id
    @Column
    private String id;

    @Column
    private String pwd;

    @Column
    private String name;

    @Column
    private int point;

    @Column
    private Date regdate;

    @Column
    private String grade;

    @Column
    private String email;

}
