package com.musi.shop.web.dao;

import com.musi.shop.web.dto.album.AlbumDto;
import com.musi.shop.web.entity.album.Album;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AlbumMapper {

    List<Album> findNewAlbum();
}
