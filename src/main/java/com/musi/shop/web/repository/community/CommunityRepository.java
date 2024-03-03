package com.musi.shop.web.repository.community;

import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    // 검색
    List<Community> findByTitleContaining(String keyword); // 제목검색
}
