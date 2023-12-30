package com.musi.shop.web.repository.playlist;

import com.musi.shop.web.entity.playlist.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
