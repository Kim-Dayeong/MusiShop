package com.musi.shop.web.repository.heart;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.album.Heart;
import com.musi.shop.web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {

    Heart findByAlbumAndMember(Album album, Member member);

    List<Heart> findAllByMemberUsername(String username);

}
