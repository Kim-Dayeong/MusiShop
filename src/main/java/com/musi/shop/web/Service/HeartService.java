package com.musi.shop.web.Service;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Heart;
import com.musi.shop.web.entity.HeartAlbum;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.HeartAlbumRepository;
import com.musi.shop.web.repository.HeartRepository;
import com.musi.shop.web.repository.MemberRepository;
import com.musi.shop.web.web.dto.AlbumDto;
import com.musi.shop.web.web.dto.HeartAlbumDto;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HeartService {

    private final MemberRepository memberRepository;
    private final AlbumRepository albumRepository;
    private final HeartRepository heartRepository;
    private final HeartAlbumRepository heartAlbumRepository;

    @Transactional
    public String HeartAlbum(Long id) {
        Album album = albumRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        PrincipalDetail principalDetail = (PrincipalDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Member member = (memberRepository.findByUsername(principalDetail.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("Member not found")));

        AlbumDto albumDto = new AlbumDto();
        albumDto.setId(album.getId());
        String albumtest = album.getName();
    //    Heart albumtest22 = heartRepository.findByAlbumIdAndMemberId(album, member);

        //if(heartRepository.findByAlbumIdAndMemberId(album, member) == null){

           String albumtest2 = album.getName();
            // 좋아요 누른적 없으면 heartAlbum 생성후 좋아요 처리
//
                album.setHeartcnt(album.getHeartcnt() + 1);


            HeartAlbum heartalbum = new HeartAlbum(album,member); //true 처리

//            HeartAlbumDto heartAlbumDto = new HeartAlbumDto();
//            heartAlbumDto.setAlbumId(Math.toIntExact(album.getId()));
//            heartAlbumDto.setMemberId(Math.toIntExact(member.getId()));
//            HeartAlbum heartAlbumentity = heartAlbumDto.toEntity(album, member);


           heartAlbumRepository.save(heartalbum);
            return "좋아요 처리 완료";
//        }else {
//            // 좋아요 누른적 있으면 취소 후 테이블 삭제
//            HeartAlbum heartAlbum = heartAlbumRepository.findByAlbumAndMember(album, member);
//            heartAlbum.unHeartAlbum(album);
//            heartAlbumRepository.delete(heartAlbum);
//            return "좋아요 취소";
//        }

    }



//    @Transactional
//    public String HeartAlbum(Long id) {
//        Album album = albumRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//
//        PrincipalDetail principalDetail = (PrincipalDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        Member member = (memberRepository.findByUsername(principalDetail.getUsername())
//                .orElseThrow(() -> new EntityNotFoundException("Member not found")));
//
//
//        if(heartRepository.findByAlbumIdAndMemberId(album, (member)) == null){
//            // 좋아요 누른적 없으면 heartAlbum 생성후 좋아요 처리
//            album.setHeartcnt(album.getHeartcnt() + 1);
//            HeartAlbum heartalbum = new HeartAlbum(album,member); //true 처리
//            heartAlbumRepository.save(heartalbum);
//            return "좋아요 처리 완료";
//        }else {
//            // 좋아요 누른적 있으면 취소 후 테이블 삭제
//            HeartAlbum heartAlbum = heartAlbumRepository.findByAlbumAndMember(album, member);
//            heartAlbum.unHeartAlbum(album);
//            heartAlbumRepository.delete(heartAlbum);
//            return "좋아요 취소";
//        }

//        @Transactional
//        public String heartFavorite(int id){ //좋아요한 앨범 즐겨찾기
//
//        }


    }



//    @Transactional
//    public void addLikeToAlbum(Long albumId, Long memberId) throws Exception {
//        Member member = memberRepository.findById(memberId)
//                .orElseThrow(() -> new NotFoundException("Could not found member id : " + memberId));
//
//        Album album = albumRepository.findById(albumId)
//                .orElseThrow(() -> new NotFoundException("Could not found member id : " + albumId));
//
//        Optional<Heart> existingLike = heartRepository.findByAlbumIdAndMemberId(albumId,memberId);
//
//        if(existingLike.isPresent()) {
//            // 이미 좋아요 상태인 경우 좋아요 삭제
//            heartRepository.delete(existingLike.get());
//        }else {
//            //좋아요 하지 않은 경우 좋아요 추가
//            Heart newLike = new Heart();
//            newLike.setAlbum(album);
//            newLike.setMember(member);
//            heartRepository.save(newLike);
//
//        }
//
//    }

