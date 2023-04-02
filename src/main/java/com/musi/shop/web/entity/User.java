package com.musi.shop.web.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="User")
@Getter
@Setter
public class User {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String pwd;

    @Column
    private String name;

    @Column
    private String email;



    public User() {
    }
    public User(String email, String pwd, String name){
        this.name = name;
        this.pwd = pwd;
        this.email = email;
    }
}
