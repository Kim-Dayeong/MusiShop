package com.musi.shop.web.service.member;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.entity.Member;

import com.musi.shop.web.repository.member.MemberRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j

public class MemberDetailsService implements UserDetailsService {
    @Autowired
   private MemberRepository memberRepository;

    public MemberDetailsService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberEntityOptional = memberRepository.findByUsername(username);

        Member member = memberEntityOptional.orElseThrow(() -> new UsernameNotFoundException("사용자가 존재하지 않습니다: " + username));
        return new PrincipalDetail(member);
    }
    }

