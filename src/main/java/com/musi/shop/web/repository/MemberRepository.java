package com.musi.shop.web.repository;

import com.musi.shop.web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long>{
    Optional<Member> findByemail(String email);

}