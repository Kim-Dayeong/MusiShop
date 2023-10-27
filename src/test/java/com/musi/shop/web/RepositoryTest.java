package com.musi.shop.web;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


@SpringBootTest
public class RepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    //findusername 테스트

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

}
