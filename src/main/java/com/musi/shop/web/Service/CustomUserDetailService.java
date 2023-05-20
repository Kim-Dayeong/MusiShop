package com.musi.shop.web.Service;

import com.musi.shop.web.entity.LoginUser;
import com.musi.shop.web.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginRepository.findByMemberId(username).map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을수 없습니다."));

    }
    //해당 유저 데이터가 존재하면 userDetails 객체로 만들어 리턴
    private UserDetails createUserDetails(LoginUser loginUser){
        return User.builder()
                .username(loginUser.getUsername())
                .password(passwordEncoder.encode(loginUser.getPassword()))
                .roles(loginUser.getRoles().toArray(new String[0]))
                .build();
    }

}
