package com.musi.shop.web.Service.posts;

import com.musi.shop.web.web.domain.posts.Posts;
import com.musi.shop.web.web.domain.posts.PostsRepository;
import com.musi.shop.web.web.dto.PostsResponseDto;
import com.musi.shop.web.web.dto.PostsSaveRequestDto;
import com.musi.shop.web.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        return new PostsResponseDto(entity);
    }
}
