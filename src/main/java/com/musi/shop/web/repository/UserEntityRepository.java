package com.musi.shop.web.repository;

import com.musi.shop.web.entity.LoginUser;
import com.musi.shop.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository <User,Integer> {

    User findByEmail(String email); //이메일로 중복 검사


    }

