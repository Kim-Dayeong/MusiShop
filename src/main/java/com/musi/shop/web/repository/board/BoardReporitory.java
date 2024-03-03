package com.musi.shop.web.repository.board;

import com.musi.shop.web.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardReporitory extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update Board b set b.view = b.view + 1 where b.id = :id")
    int updateView(Long id); // 조회수 증가

    // 검색
    List<Board> findByTitleContaining(String keyword); // 제목검색

}
