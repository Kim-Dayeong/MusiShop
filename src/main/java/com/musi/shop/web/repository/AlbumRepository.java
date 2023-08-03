package com.musi.shop.web.repository;


import com.musi.shop.web.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Optional<Album> findByAlbumid(int albumid);

}
