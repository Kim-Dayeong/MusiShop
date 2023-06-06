package com.musi.shop.web.controller;


import com.musi.shop.web.Service.MemberService;
import com.musi.shop.web.config.TokenDto;
import com.musi.shop.web.web.dto.MemberLoginRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class Membercontroller {

    private final MemberService memberService;

    @PostMapping("/login")
    private TokenDto login(@RequestBody MemberLoginRequestDto memberLoginRequestDto){
        String email = memberLoginRequestDto.getEmail();
        String pwd = memberLoginRequestDto.getPwd();
        TokenDto tokenDto = memberService.login(email, pwd);
        return tokenDto;
    }

    @PostMapping("/test")
    public String test(){
        return "sucess";
    }

}
