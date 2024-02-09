package com.musi.shop.web.repository.member;

import com.musi.shop.web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long>{
 //   Optional<Member> findByemail(String email);
    Optional <Member> findByUsername(String username);



    Optional<Member> findByEmail(String email);
    // Member 엔티티에서 nickname을 사용하여 Channel의 id를 조회하는 메서드
    @Query("SELECT m.channel.id FROM Member m WHERE m.username = :username")
    Long findChannelIdByUsername(@Param("username") String username);
}
