package com.musi.shop.web.dto.member;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MemberDto {

    private String username;
    private String password;
    private String nickname;
    private String email;
    private Role role;

    // dto -> entity
    public Member toEntity(){
        Member member = Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(role)
                .build();
        return member;
    }
}
