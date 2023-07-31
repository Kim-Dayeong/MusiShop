package com.musi.shop.domain;

import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.SongRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

//@RuntWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest

public class AlbumTest {


     AlbumRepository albumRepository;
    SongRepository songRepository;


    @Test
    public void album과song조회() throws Exception{
        System.out.println(albumRepository.findByAlbumid(12).get());
       // Album album = albumRepository.findByAlbumid(3063).get();
      //  System.out.println(album);

        //List<Song> songList = album.getSongs();
       // for(Song song: songList){
      //      System.out.println(song.getSong_name());
      //  }
    }


}
