package com.musi.shop.web.Service;

import com.musi.shop.web.config.JwtTokenProvider;
import com.musi.shop.web.entity.User;
import com.musi.shop.web.repository.LoginRepository;
import com.musi.shop.web.repository.UserEntityRepository;
import com.musi.shop.web.web.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import ognl.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginService {

    private final LoginRepository loginRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenDto login(String memberId, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password); //id,pw기반으로 authentication 객체 생성 , autehnticated 값 false
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken); // 사용자 비밀번호체크(실제검증)
        TokenDto tokenInfo = jwtTokenProvider.generateToken(authentication); //인증정보를 기반으로 토큰 생성

        return tokenInfo;


    }

}