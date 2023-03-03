package com.musi.shop.web.repository;


import com.musi.shop.web.entity.AlbumCrudEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AlbumCrudEntityRepository extends JpaRepository<AlbumCrudEntity, Integer> {
//
//    @Query(value = "select albumid, albumTitle,artist,price,img,regdate where albumid =:albumid", nativeQuery = true)
//    List<AlbumCrudEntity> searchParamRepo(@Param("albumid")String albumid);


}
