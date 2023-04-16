package com.musi.shop.web.Service;

import com.musi.shop.web.entity.User;
import com.musi.shop.web.repository.UserEntityRepository;
import com.musi.shop.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserEntityRepository userEntityRepository;

    public User saveUser(User user){
        validateDuplicateUser(user);

        return userEntityRepository.save(user);

    }

    private void validateDuplicateUser(User user) {
        User findUser = userEntityRepository.findByEmail(user.getEmail());
        if (findUser != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
