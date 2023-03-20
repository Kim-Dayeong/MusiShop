package com.musi.shop.web.repository;

import com.musi.shop.web.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEntityRepository extends JpaRepository <Users,Integer> {

}
