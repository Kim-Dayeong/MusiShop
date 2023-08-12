package com.musi.shop.web.repository;


import com.musi.shop.web.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByAlbumId(Long albumId);
}
