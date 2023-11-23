package com.musi.shop.web.repository;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.HeartAlbum;
import com.musi.shop.web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeartAlbumRepository extends JpaRepository<HeartAlbum, Integer> {

    HeartAlbum findByAlbumAndMember(Album album, Member member);
}
