package com.musi.shop.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //스프링부트 테스트와 junit 사이 연결자 역할
@WebMvcTest(controllers = HelloController.class)//스프링 테스트 어노테이션, 컨트롤러에 사용 가능
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 빈 주입
    private MockMvc mvc; // 웹 api를 테스트할때 사용 , 스프링 mvc 테스트 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // mockmvc를 통해 /hello로 get 요청
                .andExpect(status().isOk()) // 200인지 아닌지 검증
                .andExpect(content().string(hello)); //컨트롤러에서 hello를 리턴하는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount",String.valueOf(amount))
        )
                        .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));



    }


}
