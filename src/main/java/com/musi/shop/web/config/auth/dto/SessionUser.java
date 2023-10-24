package com.musi.shop.web.config.auth.dto;

import com.musi.shop.web.entity.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String nickname;
    private String email;
    private String picture;


    public SessionUser(Member member){
        this.nickname =member.getNickname() ;
        this.email = member.getEmail();
        this.picture = member.getPicture();

    }
}
