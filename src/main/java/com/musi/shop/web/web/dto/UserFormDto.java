package com.musi.shop.web.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musi.shop.web.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

//@NoArgsConstructor
//@Getter
public class UserFormDto {

    //@NotBlank(message ="이름은 비워둘수 없습니다.")
    @JsonProperty("name")
    private String name;

   //@NotEmpty(message = "이메일은 비워둘수 없습니다.")
    //@Email(message = "틀린 이메일 입니다.")
   @JsonProperty("email")
    private String email;

    //@NotEmpty(message = "비밀번호는 비워둘수 없습니다.")
    //@Length(min =4, max=16, message = "비밀번호는 4자 이상 16자 이하로 입력해주세요")
    @JsonProperty("pwd")
    private String pwd;

    @Builder
    public UserFormDto(String name, String email, String pwd){
        this.name = name;
        this.email = email;
        this.pwd = pwd;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    //dto -> entity
    public User toEntity() {
        User user = User.builder()

                .name(name)
                .email(email)
                .pwd(pwd)
                .build();

        return user;
    }



}
