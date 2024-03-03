package com.musi.shop.web.repository.playlist;

import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.playlist.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByMemberId(Long memberId);
    List<Playlist> findByMember_Username(String username);

    // 검색
    List<Playlist> findByTitleContaining(String keyword); // 제목검색
}
