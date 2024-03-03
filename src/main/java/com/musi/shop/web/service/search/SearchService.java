package com.musi.shop.web.service.search;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.community.Community;
import com.musi.shop.web.entity.playlist.Playlist;
import com.musi.shop.web.entity.song.Song;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.board.BoardReporitory;
import com.musi.shop.web.repository.community.CommunityRepository;
import com.musi.shop.web.repository.playlist.PlaylistRepository;
import com.musi.shop.web.repository.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SongRepository songRepository;
    private final BoardReporitory boardReporitory;
    private final PlaylistRepository playlistRepository;
    private final AlbumRepository albumRepository;
    private final CommunityRepository communityRepository;



    // 음악 검색
    public List<Song> searchSong(String keyword){
        List<Song> songList = songRepository.findBySongnameContaining(keyword);

        return songList;
    }
    // 게시판 검색
    public List<Board> searchBoard(String keyword){
        List<Board> boardList = boardReporitory.findByTitleContaining(keyword);

        return boardList;
    }
    // 앨범 검색

    public List<Album> searchAlbum(String keyword){
        List<Album> albumList= albumRepository.findByTitleContaining(keyword);

        return albumList;
    }

    // 커뮤니티 검색

    public List<Community> searchCommunity(String keyword){
        List<Community> communityList = communityRepository.findByTitleContaining(keyword);

        return communityList;
    }

    // 플레이리스트 검색

    public List<Playlist> searchPlaylist(String keyword){
        List<Playlist> playlistsList = playlistRepository.findByTitleContaining(keyword);

        return playlistsList;
    }


}
