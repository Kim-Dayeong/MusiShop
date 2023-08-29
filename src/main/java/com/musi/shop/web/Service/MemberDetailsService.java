package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.MemberDetails;
import com.musi.shop.web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    @Autowired
   private MemberRepository memberRepository;
    private final HttpSession session;
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username).orElseThrow
                new UsernameNotFoundException("사용자가 존재하지 않습니다."));

        return null;
    }


}
