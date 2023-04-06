package com.musi.shop.web.repository;

import com.musi.shop.web.entity.User;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class UserRepository {

    private static Map<Long, User> store = new HashMap<>();   // static 사용
    private static long sequence = 0L;

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<User> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getEmail().equals(loginId))
                .findFirst();
    }

}