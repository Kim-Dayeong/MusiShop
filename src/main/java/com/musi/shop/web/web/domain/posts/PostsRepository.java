package com.musi.shop.web.web.domain.posts;

import com.musi.shop.web.web.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {

}
