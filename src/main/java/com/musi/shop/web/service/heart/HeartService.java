package com.musi.shop.web.service.heart;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.album.HeartAlbum;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.heart.HeartAlbumRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HeartService {

    private final MemberRepository memberRepository;
    private final AlbumRepository albumRepository;
    // private final HeartRepository heartRepository;
    private final HeartAlbumRepository heartAlbumRepository;

    @Transactional
    public String HeartAlbum(Long id, String username) {
        Album album = albumRepository.findById(id).orElseThrow(EntityNotFoundException::new);

//        PrincipalDetail principalDetail = (PrincipalDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Member member = (memberRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Member not found")));

        HeartAlbum heartalbum = heartAlbumRepository.findByAlbumAndMember(album, member);

        if (heartalbum != null) {
            // 좋아요 누른적 있으면 취소 후 테이블 삭제
            heartalbum.unHeartAlbum(album);
            heartAlbumRepository.delete(heartalbum);
            return "좋아요 취소";


        }
        // 좋아요 누른적 없으면 heartAlbum 생성후 좋아요 처리
        album.setHeartcnt(album.getHeartcnt() + 1);
        heartalbum = new HeartAlbum(album, member); //true 처리

        heartAlbumRepository.save(heartalbum);
        return "좋아요 처리 완료";

    }
}

