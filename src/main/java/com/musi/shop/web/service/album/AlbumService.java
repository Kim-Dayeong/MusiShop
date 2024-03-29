package com.musi.shop.web.service.album;

import com.musi.shop.web.mapper.AlbumMapper;
import com.musi.shop.web.entity.album.Album;

import com.musi.shop.web.entity.channel.Channel;
import com.musi.shop.web.entity.song.Song;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.channel.ChannelRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.repository.song.SongRepository;

import com.musi.shop.web.dto.album.AlbumDto;

import com.musi.shop.web.dto.song.SongDto;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
    private final ChannelRepository channelRepository;
    @Autowired
   private final AlbumMapper albumMapper;

    @Autowired
    PlatformTransactionManager manager;




    // 최신 앨범 불러오기 (4개)
//    public List<Album> newAlbum(){
//
//        return albumMapper.findNewAlbum();
//    }

    public List<Album> newAlbum(){
        return albumRepository.findTop4ByOrderByIdDesc();
    }


    // 인기 앨범 불러오기
//    public Album bestAlbum(){
//        return albumMapper.bestAlbum();
//
//    }

    public Album bestAlbum(){
        return albumRepository.findTop1ByOrderByViewDesc();

    }

    //페이징
    public Page<Album> albumList(Pageable pageable) { //앨범 불러오기
        return albumRepository.findAll(pageable);
    }


    //쓰기
    @Transactional
    public void write(AlbumDto albumDto
            ,List<SongDto> songDtos
    ,Album album, String username, String nickname, String img){

        //앨범

       Long channelId = memberRepository.findChannelIdByUsername(username);
        Optional<Channel> channelOptional = channelRepository.findById(channelId); //채널 아이디로 검색

        if (channelOptional.isPresent()) {

            album.setTitle(albumDto.getTitle());
            album.setPrice(albumDto.getPrice());
            album.setImg(img);
            album.setRegdate(albumDto.getRegdate());
            album.setId(albumDto.getId());
            album.setName(nickname);
            Channel channel = channelOptional.get();
            album.setChannel(channel);
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
    // 조회수
    @Transactional
    public int updateView(Long id){
        return albumRepository.updateView(id);
    }

    //읽기
    //수정 전 코드
    @Transactional
    public AlbumDto getAlbumWithSongs(Long id){
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("앨범을 찾을 수 없습니다  : " + id));
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

    // 삭제
    public void albumDelte(Long id){

        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("앨범을 찾을 수 없습니다  : " + id));
        albumRepository.delete(album);
    }


    }


