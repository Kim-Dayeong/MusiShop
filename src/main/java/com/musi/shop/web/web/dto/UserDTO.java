package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDTO {

    private String id;
    private String pwd;
    private String name;
    private String email;

    public static UserDTO toUserDTO(User user){
        UserDTO userDTO  =new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPwd(user.getPwd());
        userDTO.setName(user.getName());
        return userDTO;
    }


}
