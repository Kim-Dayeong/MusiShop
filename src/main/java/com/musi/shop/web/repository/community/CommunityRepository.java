package com.musi.shop.web.repository.community;

import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.community.Community;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    // 검색
    List<Community> findByTitleContaining(String keyword); // 제목검색

    Page<Community> findById(long id, Pageable pageable);

    Page<Community>  findByChannel_Id(Long channelId, Pageable pageable); // 채널 아이디로 커뮤니티 검색
}
