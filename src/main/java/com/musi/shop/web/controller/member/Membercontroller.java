package com.musi.shop.web.controller.member;




import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.member.MemberUpdateDTO;
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
        if (userRepository.findByUsername(member.getUsername()) != null){
            return "아이디 중복입니다.";
        } // 이 부분 수정

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

    @GetMapping("user/exit")
    public String getUserexit(){
        return "user/user-exit";
    }

    @PostMapping("/user/exit") // 회원 탈퇴
    private String userExit(@AuthenticationPrincipal PrincipalDetail principalDetail){
        if(principalDetail == null){
            System.out.println("접근 불가");
            return "redirect:/";
        }
        memberService.userExit(principalDetail.getUsername());

        return "redirect:/logout";
    }


// 회원 수정
    @PostMapping("/user/update")
    private String postUserupdate(@AuthenticationPrincipal PrincipalDetail principalDetail,
                                  MemberUpdateDTO memberUpdateDTO){
        memberService.userupdate(principalDetail.getUsername(),memberUpdateDTO);

        return "redirect:/logout";
    }

    @GetMapping("/user/update")
    private String getUserupdate(){

        return "user/user-update";

    }



}
