package com.musi.shop.web.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int id;
    private String pwd;
    private String name;
    private String email;

//    public static UserDTO toUserDTO(User user){
//        UserDTO userDTO  =new UserDTO();
//
//        userDTO.setId(user.getId());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPwd(user.getPwd());
//        userDTO.setName(user.getName());
//        return userDTO;
//    }


}
