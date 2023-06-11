package com.musi.shop.web.Service;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.MemberDetails;
import com.musi.shop.web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailsService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        Member member = memberRepository.findByUsername(username);
        if(member != null){
            return new MemberDetails(member);
        }
        return null;
    }

}
