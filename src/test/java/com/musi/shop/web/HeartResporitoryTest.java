package com.musi.shop.web;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.album.Heart;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.heart.HeartRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HeartResporitoryTest {
    @Autowired
    private HeartRepository heartRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testFindByAlbumAndMember() {
        // Given
        Album album = new Album();
        album.setName("Test Album");


        Member member = new Member();
        member.setUsername("testUser");
        member.setEmail("test@example.com");

        // Save album and member to the database
        albumRepository.save(album);
        memberRepository.save(member);

        Heart heart = new Heart();
        heart.setAlbum(album);
        heart.setMember(member);

        // Save heart to the database
        heartRepository.save(heart);

        // When
        Heart foundHeart = heartRepository.findByAlbumAndMember(album, member);

        // Then
        assertNotNull(foundHeart);
        assertEquals(heart.getId(), foundHeart.getId());
        assertEquals(heart.getAlbum().getId(), foundHeart.getAlbum().getId());
        assertEquals(heart.getMember().getId(), foundHeart.getMember().getId());
    }
}
