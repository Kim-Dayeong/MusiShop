package com.musi.shop.web.config.auth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2MemberService extends DefaultOAuth2UserService { //OAuth 로그인에 성공후 실행됨

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("!!!!!!OAuth2User = " + oAuth2User.getAttributes());
        return super.loadUser(userRequest);
    }
}
