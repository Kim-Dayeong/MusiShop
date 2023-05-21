package com.musi.shop.web.web.dto;

import lombok.Data;

@Data
public class UserLoginRequestDto {

    private String email;
    private String pwd;
}
