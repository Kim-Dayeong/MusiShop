package com.musi.shop.web.service.album;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.Member;

import com.musi.shop.web.entity.song.Song;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.repository.song.SongRepository;

import com.musi.shop.web.dto.album.AlbumDto;

import com.musi.shop.web.dto.song.SongDto;
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
            album.setHeartcnt(0L);
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
    //수정 전 코드
    @Transactional
    public AlbumDto getAlbumWithSongs(Long id){
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("album not found with id : " + id));
            List<Song> songs = songRepository.findByAlbumId(id);

            List<SongDto> songDtos = songs.stream()
                    .map(SongDto::newWithoutAlbum)
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



    }


