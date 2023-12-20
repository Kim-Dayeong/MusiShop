package com.musi.shop.web.controller.community;


import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.community.CommunityRequestDto;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    // create
    @PostMapping("/commu/{id}/write")
    public String writeCommu(@PathVariable Long id, @ModelAttribute CommunityRequestDto commuRequestDto,
                             @AuthenticationPrincipal PrincipalDetail principalDetail,
                             Community community){
        communityService.createCommunity(commuRequestDto, principalDetail.getUsername(), community, id);
        return "redirect:/";

    }

}
