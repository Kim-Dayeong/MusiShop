package com.musi.shop.web.controller.community;


import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.channel.ChannelDto;
import com.musi.shop.web.dto.community.CommunityRequestDto;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Pageable;

@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    //커뮤니티 목록 view
    @GetMapping("/commu/{id}/view") //id = 커뮤니티 id
    public String viewCommuGet(@PathVariable Long id , Model model){
        communityService.communityList(id);
        model.addAttribute("comulist",model);
        return "/community/commu-list";
    }

    // create

    @GetMapping("/commu/{id}/write")
    public String writeCommuGet(@PathVariable Long id, Model model){
        CommunityRequestDto communityRequestDto = new CommunityRequestDto();
        model.addAttribute("channelid", id);

        return "/community/commu-write";
    }


    @PostMapping("/commu/{id}/write")
    public String writeCommu(@PathVariable Long id, @ModelAttribute CommunityRequestDto commuRequestDto,
                             @AuthenticationPrincipal PrincipalDetail principalDetail,
                             Community community){
        communityService.createCommunity(commuRequestDto, principalDetail.getUsername(), community, id);
        return "redirect:/";

    }

}
