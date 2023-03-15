package com.musi.shop.web.Service;

import com.musi.shop.web.entity.User;
import com.musi.shop.web.repository.UserEntityRepository;
import com.musi.shop.web.web.dto.UserDTO;
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

    public ResponseEntity signup(UserDTO formDTO) {

        Optional<User> user = userEntityRepository.findById(formDTO.getEmail());

        if(user.isEmpty()) {
            User newUser = User.builder()
                    .id(formDTO.getId())
                    .pwd(formDTO.getPwd())
                    .name(formDTO.getName())
                    .email(formDTO.getEmail())
                    .build();

            userEntityRepository.save(newUser);

            return new ResponseEntity("sucess", HttpStatus.OK);
        } else {
            return new ResponseEntity("fail", HttpStatus.OK);
        }

    }

    public UserDTO login(UserDTO userDTO) {

        Optional<User> optionalUser = userEntityRepository.findByid(userDTO.getEmail());
        if(optionalUser.isPresent()) {
            User loginEntity = optionalUser.get();
            if(loginEntity.getPwd().equals(userDTO.getPwd())){
                return UserDTO.toUserDTO(loginEntity);
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
}
