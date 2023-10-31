package com.musi.shop.web.repository;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    Optional<Like> findByAlbumIdAndUserId(Long albumId, Long userId);
}
