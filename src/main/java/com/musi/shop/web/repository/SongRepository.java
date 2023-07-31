package com.musi.shop.web.repository;

import com.musi.shop.web.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Album, Integer> {
}
