package com.musi.shop.web.Service;

import com.musi.shop.web.web.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    String String(UserDTO userDTO);

}
