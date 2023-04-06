package com.musi.shop.web.Service;

import com.musi.shop.web.entity.User;
import com.musi.shop.web.repository.UserEntityRepository;
import com.musi.shop.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    // @return null 로그인 실패
    public User login(String loginId, String password){
        return userRepository.findByLoginId(loginId)
                .filter(m -> m.getPwd().equals(password))
                .orElse(null);

    }
}
