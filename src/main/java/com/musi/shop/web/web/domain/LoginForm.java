package com.musi.shop.web.web.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class LoginForm {


    private String email;


    private  String password;
}
