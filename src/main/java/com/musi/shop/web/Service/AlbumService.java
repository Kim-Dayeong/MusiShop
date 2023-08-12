package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Song;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.SongRepository;
import com.musi.shop.web.response.AlbumListResponse;

import com.musi.shop.web.web.dto.AlbumDto;
import com.musi.shop.web.web.dto.SongDto;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Transactional
@RequiredArgsConstructor //생성자 주입
@Service
public class AlbumService {


    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;


    //페이징
    public Page<Album> albumList(Pageable pageable) { //앨범 불러오기
        return albumRepository.findAll(pageable);
    }


    //쓰기
    @Transactional
    public void write(AlbumDto albumDto, List<SongDto> songDtos){

        //앨범
        Album album = albumDto.toEntity();
         albumRepository.save(album);

         //음악
//        Song song = songDto.toEntity();
//        song.setAlbum(album);
//        songRepository.save(song);

        List<Song> songs = new ArrayList<>();
        for (SongDto songDto : songDtos){
            Song song = songDto.toEntity();
            song.setAlbum(album);
            songs.add(song);
        }
        songRepository.saveAll(songs);

    }

    //읽기
    @Transactional
    public AlbumDto getAlbum(Long id){
        Optional<Album> albumWrapper = albumRepository.findById(id);
        Album album = albumWrapper.get();

        AlbumDto albumDto = AlbumDto.builder()
                .id(album.getId())
                .title(album.getTitle())
                .name(album.getName())
                .regdate(album.getImg())
                .img(album.getImg())
                .build();

        return albumDto;

    }





        //읽기


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


