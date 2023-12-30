package com.musi.shop.web.repository.song;


import com.musi.shop.web.entity.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByAlbumId(Long albumId);
    List<Song> findBySongnameContaining(String keyword); //song 검색
}
