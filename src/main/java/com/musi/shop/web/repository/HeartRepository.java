package com.musi.shop.web.repository;

import com.musi.shop.web.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {

    Optional<Heart> findByAlbumIdAndMemberId(Long albumId, Long memberId);
}
