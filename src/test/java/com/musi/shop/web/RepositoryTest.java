package com.musi.shop.web;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class RepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    //findusername 테스트
    @Autowired
    private AlbumRepository albumRepository;

    @Test
    public void testFineBtUsername(){
        //given
        String username = "testuser@naver.com";


        //when
        Optional<Member> foundMember = memberRepository.findByUsername(username);

        //then
        assertTrue(foundMember.isPresent());
        System.out.println(foundMember);
//        assertEquals(username,foundMember.get().getUsername());
//        assertEquals(password, foundMember.get().getPassword());

    }

    @Test
    public void testFindAlbumByUserId(){
        //given
        Member member = new Member();
        member.setId(2L);
        //when
        List<Album> albums = albumRepository.findAlbumByUserId(2L);
        //then
        assertThat(albums).isNotNull();
        for (Album album : albums){
            System.out.println("테스트!!!!!!!!!!!!!!!!!!!!"+album.getTitle());
        }

    }

    @Test
    public void testFindAlbumByalbumId() {

        Optional<Album> album = Optional.of(new Album());

        album = albumRepository.findById(1L);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+album);

    }
    }


