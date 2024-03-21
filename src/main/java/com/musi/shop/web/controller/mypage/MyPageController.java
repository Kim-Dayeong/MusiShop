package com.musi.shop.web.controller.mypage;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.service.mypage.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {
    @Autowired
    MemberRepository userRepository;

    @Autowired
    private final MypageService mypageService;


    @GetMapping("/")
    public String myPage(Model model){

        return "page/my-page";
    }

    @GetMapping("/bookmark")
    public String myBookmark(Model model, @AuthenticationPrincipal PrincipalDetail principalDetail){


        model.addAttribute("bookmarks", mypageService.myBoardBookmark(principalDetail.getUsername()));
        return "page/my-bookmark";


    }

    @GetMapping("/likealbum")
    public String myLikesong(Model model, @AuthenticationPrincipal PrincipalDetail principalDetail){
        model.addAttribute("likes",mypageService.myAlbumHeart(principalDetail.getUsername()));

        return "page/like-album";

    }

}
