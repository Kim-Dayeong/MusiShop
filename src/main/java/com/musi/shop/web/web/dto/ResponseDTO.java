package com.musi.shop.web.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class ResponseDTO {
    private String name;
    private int id;
    private String email;
    private String pwd;

}
