package com.musi.shop.web.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="Users")
@Getter
@Setter
public class Users {

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



    public Users() {
    }
    public Users(String email, String pwd, String name){
        this.name = name;
        this.pwd = pwd;
        this.email = email;
    }
}
