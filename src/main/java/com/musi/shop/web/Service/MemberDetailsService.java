package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.repository.MemberRepository;
import com.musi.shop.web.web.dto.MemberContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    @Autowired
   private MemberRepository memberRepository;
    private final HttpSession session;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Member member = memberRepository.findByUsername(username).get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("member"));

//        Member member = memberRepository.findByUsername(username).orElseThrow(() ->
//                new UsernameNotFoundException("사용자가 존재하지 않습니다."));

        /** 시큐리티 세션에 유저 정보 저장**/
       // return new MemberAdapter(member);
         new MemberAdapter(member);

        return new MemberContext(member, authorities);


    }
}
