package com.musi.shop.web.repository.comment;

import com.musi.shop.web.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardId(Long boardId); // boardId로 comment 읽어오기
}
