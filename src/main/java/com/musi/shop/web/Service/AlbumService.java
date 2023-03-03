package com.musi.shop.web.Service;

import com.musi.shop.web.entity.AlbumCrudEntity;
import com.musi.shop.web.repository.AlbumCrudEntityRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor //생성자 주입
public class AlbumService {


    private final AlbumCrudEntityRepository albumCrudEntityRepository;


    public List<AlbumCrudEntity> AlbumList() {
        return albumCrudEntityRepository.findAll();
    }
}
