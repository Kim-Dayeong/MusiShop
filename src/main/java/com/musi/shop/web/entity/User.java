package com.musi.shop.web.entity;

import com.musi.shop.web.web.dto.UserDTO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="User")
@Data
@Getter
@Setter
public class User {

    @Id
    @Column
    private String id;

    @Column
    private String pwd;

    @Column
    private String name;

    @Column
    private String email;


    public static User toSaveEntity(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());
        user.setPwd(userDTO.getPwd());
        user.setName(user.getName());
        return user;
    }

}
