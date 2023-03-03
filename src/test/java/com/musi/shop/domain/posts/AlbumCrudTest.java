package com.musi.shop.domain.posts;

import com.musi.shop.web.entity.AlbumCrudEntity;
import com.musi.shop.web.repository.AlbumCrudEntityRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class AlbumCrudTest {
    @Autowired
    AlbumCrudEntityRepository albumCrudEntityRepository;

    //조회
    @Test
    public void testSelect() {
        //Optional<AlbumCrudEntity> albumCrudEntity = albumCrudEntityRepository.findById(1L);


    }


}
