package com.musi.shop.web.Service;

import com.musi.shop.web.entity.LoginUser;
import com.musi.shop.web.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@ComponentScan(basePackages = {"com.musi.shop.web.Service"})
public class CustomUserDetailService implements UserDetailsService {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return loginRepository.findByEmail(name).map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을수 없습니다."));

    }
    //해당 유저 데이터가 존재하면 userDetails 객체로 만들어 리턴
    private UserDetails createUserDetails(LoginUser loginUser){
        return User.builder()
                .username(loginUser.getUsername())
                .password(passwordEncoder.encode(loginUser.getPassword()))
                .roles(loginUser.getRole().toArray(new String[0]))
                .build();
    }

}
