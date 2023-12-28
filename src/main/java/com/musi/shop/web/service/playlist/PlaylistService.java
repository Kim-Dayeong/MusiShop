package com.musi.shop.web.service.playlist;


import com.musi.shop.web.dto.playlist.PlaylistRequestDto;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.repository.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaylistService {
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private MemberRepository memberRepository;


    public void createPlaylist(String keyword){

    }
}
