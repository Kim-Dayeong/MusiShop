package com.musi.shop.web.config.auth;

import com.musi.shop.web.config.PrincipalDetail;
import com.musi.shop.web.config.auth.dto.OAuthAttributes;
import com.musi.shop.web.config.auth.dto.SessionUser;
import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.Role;
import com.musi.shop.web.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest,OAuth2User> {

    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Member member = saveOrUpdate(attributes);

        httpSession.setAttribute("user", new SessionUser(member));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
                        attributes.getAttributes(),
                        attributes.getNameAttributeKey());


    }

    private Member saveOrUpdate(OAuthAttributes attributes){
        Member member = memberRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getNickname(),attributes.getPicture(),attributes.getProvider()))
                .orElse(attributes.toEntity());
        member.setUsername(attributes.getEmail());
        member.setRole(Role.USER);

        return memberRepository.save(member);
    }

//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
//        // OAuth2 사용자 정보 가져오기
//        OAuth2User oAuth2User = delegate.loadUser(userRequest);
//
//        // OAuth 사용자 정보로부터 PrincipalDetail 객체 생성
//        PrincipalDetail principalDetail = createPrincipalDetail(oAuth2User);
//
//        // Spring Security 컨텍스트에 PrincipalDetail 객체 저장
//        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(principalDetail, null, principalDetail.getAuthorities()));
//
//
//        String registrationId = userRequest.getClientRegistration().getRegistrationId();
//
//        String userNameAttributeName = userRequest.
//                getClientRegistration().getProviderDetails()
//                .getUserInfoEndpoint().getUserNameAttributeName();
//
//
//        OAuthAttributes attributes = OAuthAttributes
//                .of(registrationId, userNameAttributeName,oAuth2User.getAttributes());
//
//        Member member = saveOrUpdate(attributes);
//
//        httpSession.setAttribute("user", new SessionUser(member));
//
//        return new DefaultOAuth2User(
//                Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
//                attributes.getAttributes(),
//                attributes.getNameAttributeKey());
//
//
//    }
//
//
//    private Member saveOrUpdate(OAuthAttributes attributes){
//        Member member = memberRepository.findByEmail(attributes.getEmail())
//                .map(entity -> entity.update(attributes.getNickname(),attributes.getPicture(),attributes.getProvider()))
//                .orElse(attributes.toEntity());
//        member.setUsername(attributes.getEmail());
//        member.setRole(Role.USER);
//
//        return memberRepository.save(member);
//    }
//
//    private PrincipalDetail createPrincipalDetail(OAuth2User oAuth2User) {
//
//
//        // OAuth2 사용자 정보에서 사용자 이름과 이메일 주소 추출
//        String email = (String) oAuth2User.getAttribute("email");
//        String nickname = (String) oAuth2User.getAttribute("nickname");
//
//
//        // 추출한 정보로 Member 객체 생성
//        Member member = new Member();
//        member.setEmail(email);
//        member.setUsername(email);
//        member.setNickname(nickname);
//        // Member 객체를 사용하여 PrincipalDetail 객체 생성
//        PrincipalDetail principalDetail = new PrincipalDetail(member);
//
//        // PrincipalDetail 객체 생성 및 반환
//        return principalDetail;
//    }
}
