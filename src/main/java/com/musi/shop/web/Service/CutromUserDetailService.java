//package com.musi.shop.web.Service;
//
//import com.musi.shop.web.entity.Membersdf;
//import com.musi.shop.web.repository.MemberRepository;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CutromUserDetailService implements UserDetailsService {
//    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        return memberRepository.findByemail(name)
//                .map(this::createUserDetails)
//                .orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을수 없습니다."));
//    }
//
//    private UserDetails createUserDetails(Membersdf membersdf) {
//        return User.builder()
//                .username(membersdf.getUsername())
//                .password(passwordEncoder.encode(membersdf.getPassword()))
//                .roles(membersdf.getRole().toArray(new String[0]))
//                        .build();
//    }
//
//
//}
