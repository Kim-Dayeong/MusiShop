//package com.musi.shop.web.controller;
//
//import com.musi.shop.web.Service.AlbumService;
//import com.musi.shop.web.entity.Album;
//import com.musi.shop.web.repository.AlbumRepository;
//import com.musi.shop.web.web.dto.AlbumDto;
//import com.musi.shop.web.web.dto.SongDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//
//public class AlbumCrudController {
//
//    private final AlbumService albumService;

    //쓰기
//    @PostMapping("/album/add")
//    public String albumWrite(AlbumDto albumDto, List<SongDto> songDtos){
//
//        albumService.write(albumDto,songDtos);
//        return "redirect:/";
//    }






//    @GetMapping("/search") //모든 데이터 read
//    public List<Album> list(){
//        return albumRepository.findAll();
//
//    }




//    @PostMapping("/upload")
//    public String Upload(Album crudEntity){
//        System.out.println("id : " +crudEntity.getId());
//        System.out.println("Title : " + crudEntity.getTitle());
//        System.out.println("artist: " + crudEntity.getName());
//        System.out.println("price : " + crudEntity.getPrice());
//        System.out.println("regdate : " + crudEntity.getRegdate());
//        System.out.println("img :" + crudEntity.getImg());
//       // System.out.println("img :" + crudEntity.getAlbum_title());
//
//
//        albumRepository.save(crudEntity);
//        return "앨범 등록 성공";
//    }

//    //update ..수정이 아니라 추가가 되버림 나중에 고쳐야함
//    @PutMapping("/update/{id}")
//    //public Album update(@PathVariable int id, @RequestBody Album crudEntity){ //requestbody라 json으로 날려야됨
//        public Album update(@PathVariable Long id, @RequestBody Album crudEntity){
//        Album album = albumRepository.findById(id).orElseThrow(() -> {
//            return new IllegalArgumentException("수정에 실패했습니다.");
//        });
//
//        crudEntity.setPrice(crudEntity.getPrice());
//        crudEntity.setImg(crudEntity.getImg());
//
//        albumRepository.save(crudEntity);
//        System.out.println("수정 성공");
//
//        return null;
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable Long id){
//        try{
//            albumRepository.deleteById(id);
//        }catch (EmptyResultDataAccessException e) {
//            return "삭제에 실패하였습니다. 해당 id는 db에 없습니다.";
//        }
//
//        return "삭제 완료 id: " + id;
//    }


//}
