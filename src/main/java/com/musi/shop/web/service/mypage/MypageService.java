package com.musi.shop.web.service.mypage;

import com.musi.shop.web.entity.album.Heart;
import com.musi.shop.web.entity.board.Bookmark;

import com.musi.shop.web.repository.board.BookmarkRepository;
import com.musi.shop.web.repository.heart.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MypageService {

    @Autowired
    BookmarkRepository bookmarkRepository;

    @Autowired
    HeartRepository heartRepository;


    public List<Bookmark> myBoardBookmark(String username){



        return bookmarkRepository.findAllByMemberUsername(username);

    }

    public List<Heart> myAlbumHeart(String username){

        return heartRepository.findAllByMemberUsername(username);

    }
}
