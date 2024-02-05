package com.musi.shop.web.controller.album;

import com.musi.shop.web.service.album.AlbumService;
import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.dto.album.AlbumDto;
import com.musi.shop.web.dto.song.SongDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;



@Controller
@RequiredArgsConstructor
public class AlbumController {

   private final AlbumService albumService;
// value 주입으로 수정
    private static final String UPLOAD_DIR = "/Users/kimdayeong/intelij/Musishop/src/main/resources/static/albumcover";
//private static final String UPLOAD_DIR = "/Users/kimdayeong/Documents/albumcover";




    @GetMapping("/album/list")
    public String albumList(Model model, @PageableDefault (page = 0, size = 10, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        //albumservice에서 생성한 리스트를 변수명 list로 반환
        //model.addAttribute("list",albumService.albumList());

        Page<Album> list = albumService.albumList(pageable);

        //페이지 블럭 처리
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage -3, 1);
        int endPage = Math.min(nowPage + 3, list.getTotalPages());
        int starttotal = 0;
        int endtotal = list.getTotalPages()-1;

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("starttotal", starttotal);
        model.addAttribute("endtotal", endtotal);

        return "album/albumlist";
    }

    //앨범 추가
    @GetMapping("/album/add")
    public String showAlbumForm(Model model) {
        AlbumDto albumdto = new AlbumDto();
        albumdto.setSongs(new ArrayList<>());
        model.addAttribute("albumDto", albumdto);
        return "album/album-add";
    }


    @PostMapping("/album/add")

    public String albumWrite(
            @RequestPart(value = "albumDto", required = true) AlbumDto albumDto,
            @RequestPart(value = "image", required = true) MultipartFile image,
            @AuthenticationPrincipal PrincipalDetail principalDetail,
            Album album
    ) {

        List<SongDto> songDtos = new ArrayList<>();
        for(SongDto songDto : albumDto.getSongs()){
            System.out.println(songDto.toString());
            songDtos.add(songDto);
        }

        String username = principalDetail.getUsername();
        String nickname = principalDetail.getName();
        // 이미지 파일 저장
        try {
            Path uploadPath = Path.of(UPLOAD_DIR);
            Files.createDirectories(uploadPath);

            String originalFilename = image.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf('.'));

            // Generate a unique filename with UUID
            String uniqueFilename = UUID.randomUUID().toString() + fileExtension;

            Path filePath = uploadPath.resolve(uniqueFilename);
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Received AlbumDto: " + albumDto);


            albumService.write(albumDto,songDtos, album,username, nickname,uniqueFilename );

            return "redirect:/album/list";
        } catch (IOException e) {
            e.printStackTrace();

            return "";
        }





    }



    //앨범 상세 페이지 조회
    @GetMapping("/album/view/{no}")
    public String viewAlbum(@PathVariable("no") Long no, Model model){

        AlbumDto albumDto = albumService.getAlbumWithSongs(no);
        albumService.updateView(no);
        model.addAttribute("albumDto", albumDto);

        return"album/albumview";
    }


}
