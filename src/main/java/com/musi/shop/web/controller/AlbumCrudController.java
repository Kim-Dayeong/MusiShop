package com.musi.shop.web.controller;

import com.musi.shop.web.entity.AlbumCrudEntity;
import com.musi.shop.web.repository.AlbumCrudEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class AlbumCrudController {

    private final AlbumCrudEntityRepository albumCrudEntityRepository;

    @GetMapping("/search") //모든 데이터 read
    public List<AlbumCrudEntity> list(){
        return albumCrudEntityRepository.findAll();

    }

    @PostMapping("/join")
    public String Join(AlbumCrudEntity crudEntity){
        System.out.println("id : " +crudEntity.getId());
        System.out.println("Title : " + crudEntity.getTitle());
        System.out.println("artist: " + crudEntity.getArtist());
        System.out.println("price : " + crudEntity.getPrice());
        System.out.println("regdate : " + crudEntity.getRegdate());
        System.out.println("img :" + crudEntity.getImg());
       // System.out.println("img :" + crudEntity.getAlbum_title());


        albumCrudEntityRepository.save(crudEntity);
        return "앨범 등록 성공";
    }

    //update ..수정이 아니라 추가가 되버림 나중에 고쳐야함
    @PutMapping("/update/{id}")
    public AlbumCrudEntity update(@PathVariable int id, @RequestBody AlbumCrudEntity crudEntity){
        AlbumCrudEntity albumCrudEntity = albumCrudEntityRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패했습니다.");
        });

        crudEntity.setPrice(crudEntity.getPrice());
        crudEntity.setImg(crudEntity.getImg());

        albumCrudEntityRepository.save(crudEntity);
        System.out.println("수정 성공");

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        try{
            albumCrudEntityRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            return "삭제에 실패하였습니다. 해당 id는 db에 없습니다.";
        }

        return "삭제 완료 id: " + id;
    }


}
