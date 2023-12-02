package com.musi.shop.web.repository.heart;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.album.HeartAlbum;
import com.musi.shop.web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartAlbumRepository extends JpaRepository<HeartAlbum, Long> {

    HeartAlbum findByAlbumAndMember(Album album, Member member);
}
