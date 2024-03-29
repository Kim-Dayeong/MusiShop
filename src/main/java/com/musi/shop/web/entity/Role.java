package com.musi.shop.web.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST","손님"),
    USER("ROLE_USER","일반 사용자"),
    ARTIST("ROLE_ARTIST","아티스트") ;

    private final String key;
    private final String title;

}
