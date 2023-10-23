package com.musi.shop.web.config.auth.dto;

import com.musi.shop.web.entity.OauthMember;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(OauthMember oauthMember){
        this.name = oauthMember.getName();
        this.email = oauthMember.getEmail();
        this.picture = oauthMember.getPicture();
    }
}
