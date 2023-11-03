package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Heart;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.HeartRepository;
import com.musi.shop.web.repository.MemberRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
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



    @Transactional
    public void addLikeToAlbum(Long albumId, Long memberId) throws Exception {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException("Could not found member id : " + memberId));

        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new NotFoundException("Could not found member id : " + albumId));

        Optional<Heart> existingLike = heartRepository.findByAlbumIdAndMemberId(albumId,memberId);

        if(existingLike.isPresent()) {
            // 이미 좋아요 상태인 경우 좋아요 삭제
            heartRepository.delete(existingLike.get());
        }else {
            //좋아요 하지 않은 경우 좋아요 추가
            Heart newLike = new Heart();
            newLike.setAlbum(album);
            newLike.setMember(member);
            heartRepository.save(newLike);

        }

    }
}
