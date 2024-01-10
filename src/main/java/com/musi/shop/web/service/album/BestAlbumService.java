package com.musi.shop.web.service.album;

import com.musi.shop.web.dto.board.BoardResponseDto;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.repository.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor //생성자 주입
@Service
public class BestAlbumService {
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final MemberRepository memberRepository;


    public void popularAlbum(){

    }


}
