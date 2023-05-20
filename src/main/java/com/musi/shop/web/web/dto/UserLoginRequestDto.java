package com.musi.shop.web.web.dto;

import lombok.Data;

@Data
public class UserLoginRequestDto {

    private String memberId;
    private String password;
}
