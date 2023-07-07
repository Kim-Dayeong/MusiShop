package com.musi.shop.web.controller;




import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class Membercontroller {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    MemberRepository userRepository;



    @GetMapping("/user")
    public @ResponseBody String user(Model model) {
        return "user";
    }

    @PostMapping("/joinProc")
    public String joinProc(Member member){
        String rawPassword = member.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        member.setPassword(encPassword);
        member.setRole("ROLE_USER");
        userRepository.save(member);
        return "redirect:/";
    }

    //아티스트 회원가입
    @PostMapping("/ArtjoinProc")
    public String ArtjoinProc(Member member){
        String rawPassword = member.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        member.setPassword(encPassword);
        member.setRole("ROLE_ARTIST");
        userRepository.save(member);
        return "redirect:/";
    }

    @GetMapping("/logout/result")
    public String Logoutview(){
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
