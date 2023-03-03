package com.musi.shop.web.web;

import com.musi.shop.web.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON 으로 반환하는 컨트롤러로 만들어줌
public class HelloController {

    @GetMapping("/hello") //get의 요청을 받을수 있는 api
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto") //name , amount 값 가져오기
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }


}
