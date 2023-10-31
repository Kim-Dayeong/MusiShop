package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Song;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.web.dto.AlbumDto;
import com.musi.shop.web.web.dto.SongDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor //생성자 주입
public class MemberpageService {

    private final AlbumRepository albumRepository;

    //앨범 제목,커버 받아오기
    @Transactional
    public AlbumDto getAlbumtitle(Long id) {

        List<Album> albums = albumRepository.findAlbumByUserId(id);

        //앨범에서 title , image 받아서 내보내기
        List<AlbumDto> albumDtos =
                albums.stream()
                .map(album -> {
                    AlbumDto albumDto = new AlbumDto();
                    albumDto.setTitle(album.getTitle());
                    albumDto.setImg(album.getImg());
                    albumDto.setId(album.getId());
                    return albumDto;
                })
                .collect(Collectors.toList());

        //AlbumDto 목록을 AlbumDto 객체로 묶어서 반환
        AlbumDto albumlist = new AlbumDto();
       albumlist.setAlbumsList(albumDtos);
       return albumlist;
    }


}
