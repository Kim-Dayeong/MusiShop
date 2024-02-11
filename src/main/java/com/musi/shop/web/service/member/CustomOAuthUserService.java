//package com.musi.shop.web.service.member;
//
//import com.musi.shop.web.config.PrincipalDetail;
//import com.musi.shop.web.entity.Member;
//import com.musi.shop.web.repository.member.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomOAuthUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        // OAuth2 사용자 정보 가져오기
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
//        OAuth2User oauth2User = delegate.loadUser(userRequest);
//
//        // 사용자 이름 가져오기
//        String username = (String) oauth2User.getAttribute("email");
//
//
//        // 사용자 정보 가져오기
//        Optional<Member> optionalMember = memberRepository.findByUsername(username);
//        Member member = optionalMember.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));
//
//        member.setUsername(member.getEmail());
//        // PrincipalDetail 객체 생성 및 반환
//        return new PrincipalDetail(member, oauth2User.getAttributes());
//    }
//}
