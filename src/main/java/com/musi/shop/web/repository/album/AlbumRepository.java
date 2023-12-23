package com.musi.shop.web.repository.album;


import com.musi.shop.web.entity.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Query("SELECT a FROM Album a WHERE a.channel.id = :channelId")
    List<Album> findAlbumByChannelId(@Param("channelId") Long userId); //channelid 와 조인해 album 검색


}
