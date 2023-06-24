package com.musi.shop.web.repository;


import com.musi.shop.web.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
//
//    @Query(value = "select albumid, albumTitle,artist,price,img,regdate where albumid =:albumid", nativeQuery = true)
//    List<AlbumCrudEntity> searchParamRepo(@Param("albumid")String albumid);


}
