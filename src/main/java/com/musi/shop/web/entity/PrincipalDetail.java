package com.musi.shop.web.entity;

import com.musi.shop.web.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetail implements UserDetails {

    private Member member;

    public PrincipalDetail(Member member){
        this.member = member;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
        //return(member.getUsername());
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
        collectors.add(() -> {
            return "ROLE_" + member.getRole();
        });

        return collectors;
    }
}


