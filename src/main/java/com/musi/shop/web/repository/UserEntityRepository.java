package com.musi.shop.web.repository;

import com.musi.shop.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository <User,Integer> {

}
