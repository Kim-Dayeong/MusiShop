package com.musi.shop.web.service.channel;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.channel.ChannelRepository;
import com.musi.shop.web.repository.community.CommunityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class ChannelService {

    private final ChannelRepository channelRepository;

    private final CommunityRepository communityRepository;

    private final AlbumRepository albumRepository;


    public List<Album> channelAlbum(long channelId){
        List<Album> albums = albumRepository.findAlbumByChannelId(channelId);
        return albums;
    }

    public Channel channelInfo(long chaanelId){
        Channel channel = channelRepository.findById(chaanelId).orElseThrow(() -> new EntityNotFoundException("채널을 찾을수 없습니다 " + chaanelId));
        return channel;
    }



}
