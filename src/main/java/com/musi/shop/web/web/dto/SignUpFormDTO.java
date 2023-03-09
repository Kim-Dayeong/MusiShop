package com.musi.shop.web.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SignUpFormDTO {

    private String id;
    private String pwd;
    private String name;
    private int point;
    private Date regdate;
    private String grade;
    private String email;
}
