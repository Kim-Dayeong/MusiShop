package com.musi.shop.web;

import com.musi.shop.web.Service.AlbumService;
import com.musi.shop.web.entity.Album;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.SongRepository;
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

@RunWith(SpringRunner.class)
//@SpringBootConfiguration
@SpringBootTest()
//@ContextConfiguration
public class AlbumTest {
    @Autowired
    AlbumService albumService;

     @Autowired
    AlbumRepository albumRepository;
    @Test
    public void album과song조회() throws Exception{
     //   albumService.read(3063);
//        System.out.println(albumRepository.findByAlbumid(12).get());
       // Album album = albumRepository.findByAlbumid(3063).get();
      //  System.out.println(album);

        //List<Song> songList = album.getSongs();
       // for(Song song: songList){
      //      System.out.println(song.getSong_name());
      //  }
    }

    @Test
    public void album추가() throws Exception{
        Album params = Album.builder()
                .title("앨범테스트")
                .name("테스트회원")
                .price(BigDecimal.valueOf(222))
                .img("테스트커버")
                .regdate("2023")
                .build();

        albumRepository.save(params);


    }

}
