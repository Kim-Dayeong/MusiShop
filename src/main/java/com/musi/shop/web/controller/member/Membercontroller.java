package com.musi.shop.web.controller.member;




import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.Role;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class Membercontroller {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    MemberRepository userRepository;

    private final MemberService memberService;




    @GetMapping("/user")
    public @ResponseBody String user(Model model) {
        return "user";
    }

    @PostMapping("/joinProc")
    public String joinProc(Member member){
        String rawPassword = member.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        member.setPassword(encPassword);
        member.setRole(Role.USER);
        userRepository.save(member);
        return "redirect:/";
    }

    //아티스트 회원가입
    @PostMapping("/ArtjoinProc")
    public String ArtjoinProc(Member member){

        memberService.ArtMemberJoin(member);

        return "redirect:/";
    }

    @GetMapping("/logout/result")
    public String Logoutview(){
        return "redirect:/";
    }


    //로그인 세션 확인, 회원정보 확인
    @GetMapping("/userinfo")
    public String userInfo(HttpSession session, @AuthenticationPrincipal PrincipalDetail principalDetail){

        if(principalDetail != null){
            System.out.println("현재 사용자:" + principalDetail.getUsername());
            return "redirect:/";
        }

        System.out.println("현재 사용자: 없음");
        return "redirect:/";
    }




//    @PostMapping("/login")
//    private TokenDto login(@RequestBody MemberLoginRequestDto memberLoginRequestDto){
//        String email = memberLoginRequestDto.getEmail();
//        String pwd = memberLoginRequestDto.getPwd();
//        TokenDto tokenDto = memberService.login(email, pwd);
//        return tokenDto;
//    }

//    @PostMapping("/test")
//    public String test(){
//        return "sucess";
//    }

}
