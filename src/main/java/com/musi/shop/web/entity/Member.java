package com.musi.shop.web.entity;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "Member")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String username; //email
    private Role role;
    private String password;
    private String email;
    private String picture;

    private String provider;
    private String providerId;

    @CreationTimestamp
    private Timestamp createDate;


    //private LocalDateTime last_login_time;

    @Builder
    public Member(String username, String password, String nickname, String email, Role role, String providerId, String provider, String picture){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.picture = picture;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

        public Member update(String nickname, String picture){
        this.nickname = nickname;
        this.picture = picture;

        return this;
    }

}
