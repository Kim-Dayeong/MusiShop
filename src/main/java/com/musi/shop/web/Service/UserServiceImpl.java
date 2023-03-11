package com.musi.shop.web.Service;

import com.musi.shop.web.entity.User;
import com.musi.shop.web.repository.UserEntityRepository;
import com.musi.shop.web.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserEntityRepository userEntityRepository;

    public String signup(UserDTO formDTO) {

        //dto를  entity로 변환해야함

        //userEntityRepository.save(User.toSaveEntity(formDTO));//무조건 entitiy로 받음
        User user = User.toSaveEntity(formDTO);
        String savedId = userEntityRepository.save(user).getId();
        return savedId;
    }

    public UserDTO login(UserDTO userDTO) {

        Optional<User> optionalUser = userEntityRepository.findByid(userDTO.getId());
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
