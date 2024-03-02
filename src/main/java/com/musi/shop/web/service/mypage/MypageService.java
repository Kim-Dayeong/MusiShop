package com.musi.shop.web.service.mypage;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.album.HeartAlbum;
import com.musi.shop.web.entity.board.Bookmark;

import com.musi.shop.web.repository.board.BookmarkRepository;

import com.musi.shop.web.repository.heart.HeartAlbumRepository;
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
    HeartAlbumRepository heartAlbumRepository;


    public List<Bookmark> myBoardBookmark(String username){



        return bookmarkRepository.findAllByMemberUsername(username);

    }

    public List<Album> myAlbumHeart(String username){


        List<HeartAlbum> heartAlbums = heartAlbumRepository.findAllByMemberUsername(username);
        List<Album> albums = new ArrayList<>();
        for(HeartAlbum heartAlbum : heartAlbums){
            Album album = heartAlbum.getAlbum();
            albums.add(album);
        }
        return albums;

    }
}
