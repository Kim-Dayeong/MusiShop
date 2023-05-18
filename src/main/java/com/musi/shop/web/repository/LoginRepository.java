package com.musi.shop.web.repository;

import com.musi.shop.web.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginUser, Integer> {
    Optional<LoginUser> findByMemberId(String emil);
}
