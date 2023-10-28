//package com.musi.shop.web.entity;
//
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import static java.lang.String.valueOf;
//
//@Data
//public class MemberDetails implements UserDetails {
//
//    private final Member member;
//    private String username;
//
//
//
//
//    //유저 권한목록, 반환
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities(){
//        Collection<GrantedAuthority> collect = new ArrayList<>();
//        collect.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return valueOf(member.getRole());
//            }
//        });
//        return collect;
//    }
//
//
//
//    @Override
//    public String getPassword() {
//        return member.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return member.getUsername();
//    }
//
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}