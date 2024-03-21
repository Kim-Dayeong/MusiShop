package com.musi.shop.web.controller.channel;

import com.musi.shop.web.repository.channel.ChannelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/channel")
@AllArgsConstructor
public class ChannelController {

   private final ChannelRepository channelRepository;

//    @GetMapping("/my")
//    public String viewMyChannel(){
//
//
//        retrun
//    }

    // 채널 진입시 앨범, 커뮤니티 정보 뿌ㄹ기

    @GetMapping("/all")
    public String channelAll(Model model){

        model.addAttribute("list", channelRepository.findAll());

        return"community/channel-list";
    }







}
