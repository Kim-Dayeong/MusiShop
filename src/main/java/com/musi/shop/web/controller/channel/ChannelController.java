package com.musi.shop.web.controller.channel;

import com.musi.shop.web.repository.channel.ChannelRepository;
import com.musi.shop.web.service.channel.ChannelService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/channel")
@AllArgsConstructor
public class ChannelController {

   private final ChannelRepository channelRepository;

   private final ChannelService channelService;



    // 채널 진입시 앨범, 커뮤니티 정보 뿌ㄹ기

    @GetMapping("/all")
    public String channelAll(Model model){

        model.addAttribute("list", channelRepository.findAll());

        return"community/channel-list";
    }

    @GetMapping("/{channelId}") // 특정 아티스트 채널 정보
    public String channelArtist(Model model, @PathVariable long channelId){
        model.addAttribute("channel",channelId);
        model.addAttribute("channelinfo", channelService.channelInfo(channelId));
        model.addAttribute("list",channelService.channelAlbum(channelId));

        return "channel/channel-artist";
    }









}
