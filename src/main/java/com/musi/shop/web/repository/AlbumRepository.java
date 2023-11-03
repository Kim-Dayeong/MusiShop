package com.musi.shop.web.repository;


import com.musi.shop.web.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Query("SELECT a FROM Album a WHERE a.member.id = :userId")
    List<Album> findAlbumByUserId(@Param("userId") Long userId); //userid 와 조인해 album 검색


}
