package com.musi.shop.web.controller.community;


import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.channel.ChannelDto;
import com.musi.shop.web.dto.community.CommunityRequestDto;
import com.musi.shop.web.dto.community.CommunityResponseDto;
import com.musi.shop.web.dto.comucomment.ComuCommentResDto;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.service.channel.ChannelService;
import com.musi.shop.web.service.community.CommunityService;
import com.musi.shop.web.service.comument.CommumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    private final CommumentService commumentService;

    private final ChannelService channelService;

    // read
    @GetMapping("/commu/read/{id}")
    public String readCommu(@PathVariable Long id, Model model){
        CommunityResponseDto dto = communityService.CommunityDetail(id);
        List<ComuCommentResDto> comments = commumentService.readComment(id);
        model.addAttribute("comment", comments);
        model.addAttribute("community", dto);

        return "community/commu-read";
    }

    //커뮤니티 목록 view
    @GetMapping("/commu/{id}/list") //id = 채널 id
    public String viewCommuGet(@PathVariable long id, Model model, @PageableDefault(page = 0, size = 10, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        Page<Community> list = communityService.commuList(pageable, id);

        //페이지 블럭 처리
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage -3, 1);
        int endPage = Math.min(nowPage + 3, list.getTotalPages());
        int starttotal = 0;
        int endtotal = list.getTotalPages()-1;

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("starttotal", starttotal);
        model.addAttribute("endtotal", endtotal);
        model.addAttribute("channelinfo", channelService.channelInfo(id));
//        model.addAttribute("id",)




        return "community/commu-list";
    }

    // create

    @GetMapping("/commu/{id}/write")
    public String writeCommuGet(@PathVariable Long id, Model model){
        CommunityRequestDto communityRequestDto = new CommunityRequestDto();
        model.addAttribute("channelid", id);

        return "community/commu-write";
    }


    @PostMapping("/commu/{id}/write")
    public String writeCommu(@PathVariable Long id, @ModelAttribute CommunityRequestDto commuRequestDto,
                             @AuthenticationPrincipal PrincipalDetail principalDetail,
                             Community community){
        communityService.createCommunity(commuRequestDto, principalDetail.getUsername(), community, id);
        return "redirect:/";

    }

}
