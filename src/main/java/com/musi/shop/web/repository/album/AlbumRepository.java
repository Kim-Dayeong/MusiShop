package com.musi.shop.web.repository.album;


import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.playlist.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Query("SELECT a FROM Album a WHERE a.channel.id = :channelId")
    List<Album> findAlbumByChannelId(@Param("channelId") Long userId); //channelid 와 조인해 album 검색

    @Modifying
    @Query("update Album b set b.view = b.view + 1 where b.id = :id")
    int updateView(Long id); // 조회수 증가

    // 조회수 가장 많은 앨범 1개 가져오기
    Album findTop1ByOrderByViewDesc();
    // 검색
    List<Album> findByTitleContaining(String keyword); // 제목검색


    List<Album> findTop4ByOrderByIdDesc();

}
