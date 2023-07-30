package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.response.AlbumListResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor //생성자 주입
public class AlbumService {


    private final AlbumRepository albumRepository;


    public Page<Album> albumList(Pageable pageable){ //앨범 불러오기
        return albumRepository.findAll(pageable);
    }


    //쓰기
    public void write(Album album){
        albumRepository.save(album);
    }


//    public List<AlbumListResponse> AlbumList() {
//        List<Album> album = albumRepository.findAll();
//        List<AlbumListResponse> albumList = new ArrayList<>();
//
//        for (Album a : album) {
//            AlbumListResponse list =AlbumListResponse.builder()
//                    .id(a.getId())
//                    .name(a.getName())
//                    .title(a.getTitle())
//                    .img(a.getImg())
//                    .regdate(a.getRegdate())
//                    .price(a.getPrice())
//                    .build();
//
//
//            albumList.add(list);
//        }
//        System.out.println("!!!!"+albumList.get(0).toString());
//        System.out.println(albumList.get(1).toString());
//        System.out.println(albumList.get(2).toString());
//
//        return albumList;
//    }
}
