package com.musi.shop.web.Service;

import com.musi.shop.web.entity.User;
import com.musi.shop.web.web.dto.SignUpFormDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity signup(SignUpFormDTO formTO);
}
