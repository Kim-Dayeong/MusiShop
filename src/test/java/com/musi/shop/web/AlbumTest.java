package com.musi.shop.web;

import com.musi.shop.web.Service.AlbumService;
import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Song;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.SongRepository;
import com.musi.shop.web.web.dto.AlbumDto;
import com.musi.shop.web.web.dto.SongDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootConfiguration
@SpringBootTest()
//@ContextConfiguration
public class AlbumTest {
    @Autowired
    AlbumService albumService;

     @Autowired
    AlbumRepository albumRepository;

     @Autowired
     SongRepository songRepository;
//    @Test
//    public void album과song조회() throws Exception{
//       albumService.read(3063);
//     System.out.println(albumRepository.findByAlbumid(12).get());
//        Album album = albumRepository.findByAlbumid(3063).get();
//        System.out.println(album);
//
//        List<Song> songList = album.getSongs();
//        for(Song song: songList){
//            System.out.println(song.getSong_name());
//        }
//    }

//    @Test
//    public void album추가() throws Exception{
//
//        AlbumDto albumDto = AlbumDto.builder()
//
//                .title("앨범테스트6")
//                .name("테스트회원6")
//                .price(BigDecimal.valueOf(222))
//                .img("테스트커버6")
//                .regdate("2023")
//                .build();
//
//        List<SongDto> songDtos = new ArrayList<>();
//        songDtos.add(SongDto.builder().song_name("name1").songdex(1).build());
//        songDtos.add(SongDto.builder().song_name("name2").songdex(2).build());
//        songDtos.add(SongDto.builder().song_name("name3").songdex(3).build());
//
//        albumService.write(albumDto,songDtos);
//
//
//
//    }
}
