package com.musi.shop.web.Service;

import com.musi.shop.web.entity.User;
import com.musi.shop.web.repository.UserEntityRepository;
import com.musi.shop.web.web.dto.SignUpFormDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;

    public ResponseEntity signup(SignUpFormDTO formDTO) {

        Optional<User> user = userEntityRepository.findById(formDTO.getId());

        if(user.isEmpty()) {
            User newUser = User.builder()
                    .id(formDTO.getId())
                    .pwd(formDTO.getPwd())
                    .name(formDTO.getName())
                    .point(formDTO.getPoint())
                    .grade(formDTO.getGrade())
                    .regdate(formDTO.getRegdate())
                    .email(formDTO.getEmail())
                    .build();

            userEntityRepository.save(newUser);

            return new ResponseEntity("success", HttpStatus.OK);


        }
        else{
            return new ResponseEntity("fail", HttpStatus.OK);
        }
    }
}
