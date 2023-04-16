package com.musi.shop.web.entity;

import com.musi.shop.web.web.dto.UserFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name="User")
@Entity



//@EqualsAndHashCode(of = "uid")
public class User {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String pwd;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String uid;

    @Enumerated(EnumType.STRING)
    private UserRole role;



    @Builder
    public User(String email, String pwd, String name, UserRole role){
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.role = role;

    }


    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder) {
        User user = User.builder()
                .name(userFormDto.getName())
                .email(userFormDto.getEmail())
                .pwd(passwordEncoder.encode(userFormDto.getPwd()))  //암호화처리
                .role(UserRole.USER)
                .build();
        return user;
    }


}
