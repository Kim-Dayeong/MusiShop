package com.musi.shop.web.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class UserFormDto {

    @NotBlank(message ="이름은 비워둘수 없습니다.")
    private String name;

    @NotEmpty(message = "이메일은 비워둘수 없습니다.")
    @Email(message = "틀린 이메일 입니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 비워둘수 없습니다.")
    @Length(min =4, max=16, message = "비밀번호는 4자 이상 16자 이하로 입력해주세요")
    private String pwd;

    @Builder
    public UserFormDto(String name, String email, String pwd){
        this.name = name;
        this.email = email;
        this.pwd = pwd;

    }


}
