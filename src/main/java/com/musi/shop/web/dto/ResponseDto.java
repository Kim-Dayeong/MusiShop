package com.musi.shop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto<T>{

    private int code; // 1, -1 status code
    private String msg; // message
    private T data;
}
