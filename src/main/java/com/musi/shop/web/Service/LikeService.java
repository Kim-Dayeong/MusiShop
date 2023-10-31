package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Like;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.LikeRepository;
import com.musi.shop.web.repository.MemberRepository;
import com.musi.shop.web.web.dto.LikeDto;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final MemberRepository memberRepository;
    private final AlbumRepository albumRepository;
    private final LikeRepository likeRepository;



    @Transactional
    public void addLikeToAlbum(Long albumId, Long memberId) throws Exception {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException("Could not found member id : " + memberId));

        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new NotFoundException("Could not found member id : " + albumId));

        Optional<Like> existingLike = likeRepository.findByAlbumIdAndUserId(albumId,memberId);

        if(existingLike.isPresent()) {
            // 이미 좋아요 상태인 경우 좋아요 삭제
            likeRepository.delete(existingLike.get());
        }else {
            //좋아요 하지 않은 경우 좋아요 추가
            Like newLike = new Like();
            newLike.setAlbum(album);
            newLike.setMember(member);
            likeRepository.save(newLike);

        }

    }
}
