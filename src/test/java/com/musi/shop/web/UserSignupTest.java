package com.musi.shop.web;

import com.musi.shop.web.Application;
import com.musi.shop.web.Service.UserService;
import com.musi.shop.web.entity.User;
import com.musi.shop.web.web.dto.UserFormDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = Application.class)
//@RunWith(SpringRunner.class)
@Transactional
@ComponentScan(basePackages={"com.musi.shop.web"})

public class UserSignupTest {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser() {
        UserFormDto userFormDto = UserFormDto.builder()
                .email("test@email.com")
                .name("testname")
                .pwd("testpwd")
                .build();

        return User.createUser(userFormDto, passwordEncoder);
    }

    @Test
    //@DisplayName("signupTest")
    public void saveUserTest() {
        User user = createUser();
        User savedUser = userService.saveUser(user);

        assertEquals(user.getEmail(), savedUser.getEmail());
    }
}
