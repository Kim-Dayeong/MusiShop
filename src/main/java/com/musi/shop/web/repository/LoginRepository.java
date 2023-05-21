package com.musi.shop.web.repository;

import com.musi.shop.web.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface LoginRepository extends JpaRepository<LoginUser, Integer> {
    Optional<LoginUser> findByEmail(String emil);
}
