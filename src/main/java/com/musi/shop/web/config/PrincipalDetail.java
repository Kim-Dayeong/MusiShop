package com.musi.shop.web.config;

import com.musi.shop.web.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class PrincipalDetail implements UserDetails, OAuth2User {

    private Member member;
    private Map<String,Object> attributes;



    //form 로그인
    public PrincipalDetail(Member member){
        this.member = member;

    }

    //OAuth 로그인
    public PrincipalDetail(Member member, Map<String, Object> attributes){
        this.member = member;
        this.attributes = attributes;
    }



    //OAuth2User 메소드


    @Override
    public Map<String, Object> getAttributes(){
        return attributes;
    }

    @Override
   public String getName() {
        return member.getNickname();
    }

    //form로그인
@Override
public String getUsername(){
        return member.getUsername();
}

    public String getPassword() {
        return member.getPassword();
    }


    @Override
    public boolean isAccountNonExpired() { //계정 만료 여부 true:만료x
        return true;
    }

    @Override //계정 잠김 여부
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isEnabled() { //계정 활성화 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호 만료 여부 true:만료x
        return true;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 계정 권한목록 리턴

        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole().toString();
            }

    });

        return collectors;
    }
}


