package com.musi.shop.web.service.playlist;


import com.musi.shop.web.dto.board.BoardResponseDto;
import com.musi.shop.web.dto.playlist.PlaylistCreateDto;
import com.musi.shop.web.dto.playlist.PlaylistRequestDto;
import com.musi.shop.web.dto.playlist.PlaylistResponseDto;
import com.musi.shop.web.dto.song.SongDto;
import com.musi.shop.web.dto.song.SongPlayDto;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.entity.playlist.PlaylistSong;
import com.musi.shop.web.entity.song.Song;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.repository.playlist.PlaylistRepository;
import com.musi.shop.web.repository.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
@RequiredArgsConstructor
public class PlaylistService {
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    // 플레이리스트 목록 보기
    public  List<Playlist> PlaylistView(Long memberid){
        List<Playlist> playlists = playlistRepository.findByMemberId(memberid);

        return playlists;
    }

    // 플레이리스트 목록 보기 (username)
    public  List<Playlist> PlaylistView(String username){
        List<Playlist> playlists = playlistRepository.findByMember_Username(username);

        return playlists;
    }

    // 최신 추가 된 플레이리스트 전체 보기

    public List<Playlist> PlaylistAll() {
        List<Playlist> playlists = playlistRepository.findAll();

        return playlists;
    }

    // 플레이 리스트 디테일 보기
    public PlaylistResponseDto PlaylistDetail(Long id){
        Playlist playlist = playlistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이리스트입니다."));
       PlaylistResponseDto result = PlaylistResponseDto.builder()
                .playlist(playlist)
                .build();

        return result;
    }


    // 플레이 리스트 생성
    public void createPlaylist(Long id, PlaylistCreateDto playlistCreateDto){
        Playlist playlist = new Playlist();
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 사용자가 없습니다."));
        playlist.setMember(member);
        playlist.setCreateDate(playlistCreateDto.getCreateDate());
        playlist.setTitle(playlistCreateDto.getTitle());
        playlistRepository.save(playlist);
    }

    // 플레이리스트 수정 (음악 하나씩 추가)
    public void updatePlaylist(Long playlistId,Long songId){

        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이리스트 입니다."));

        Song song = songRepository.findById(songId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 음악입니다."));
//       playlist.addSong(song); // song 추가

        playlist.getMusicSet().add(song);
        song.getPlaylistSet().add(playlist);

        playlistRepository.save(playlist);
        songRepository.save(song);

    }


}
