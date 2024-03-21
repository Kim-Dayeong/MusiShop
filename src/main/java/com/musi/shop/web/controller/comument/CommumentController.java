package com.musi.shop.web.controller.comument;


import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.dto.comucomment.ComuCommentReqDto;
import com.musi.shop.web.entity.Comucomment.ComuComment;
import com.musi.shop.web.service.comument.CommumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommumentController {

    private final CommumentService commumentService;

    // write
    @PostMapping("commu/{id}/comment")
    public String writeComment(@PathVariable Long id, ComuCommentReqDto comuCommentReqDto,
                               @AuthenticationPrincipal PrincipalDetail principalDetail){
        commumentService.writeComment(comuCommentReqDto, id, principalDetail);
        return "redirect:commu/read/"+id;
    }



}
