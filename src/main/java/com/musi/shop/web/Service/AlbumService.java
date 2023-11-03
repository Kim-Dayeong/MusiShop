package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Member;

import com.musi.shop.web.entity.Song;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.MemberRepository;
import com.musi.shop.web.repository.SongRepository;

import com.musi.shop.web.web.dto.AlbumDto;

import com.musi.shop.web.web.dto.SongDto;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@RequiredArgsConstructor //생성자 주입
@Service
public class AlbumService {


    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final MemberRepository memberRepository;


    //페이징
    public Page<Album> albumList(Pageable pageable) { //앨범 불러오기
        return albumRepository.findAll(pageable);
    }


    //쓰기
    @Transactional
    public void write(AlbumDto albumDto
            ,List<SongDto> songDtos
    ,Album album, String username, String nickname){

        //앨범

        Optional<Member> memberOptional = memberRepository.findByUsername(username);
        if (memberOptional.isPresent()) {

            album.setTitle(albumDto.getTitle());
            album.setPrice(albumDto.getPrice());
            album.setImg(albumDto.getImg());
            album.setRegdate(albumDto.getRegdate());
            album.setId(albumDto.getId());
            album.setName(nickname);
            Member member = memberOptional.get();
            album.setMember(member);
           // album.setHeartcnt();
        }else{
            System.out.println("사용자 null albumService");
        }
      albumRepository.save(album);

        //음악
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
    public AlbumDto getAlbumWithSongs(Long id){


        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("album not found with id : " + id));
            List<Song> songs = songRepository.findByAlbumId(album.getId());

            List<SongDto> songDtos = songs.stream()
                    .map(song -> SongDto.builder()
                            .song_name(song.getSong_name())
                            .songdex(song.getSongdex())
                            .build())
                    .collect(Collectors.toList());



        return AlbumDto.builder()
                .id(album.getId())
                .title(album.getTitle())
                .name(album.getName())
                .price(album.getPrice())
                .img(album.getImg())
                .regdate(album.getRegdate())
                .songs(songDtos)
               .build();

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


