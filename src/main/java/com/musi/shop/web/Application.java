package com.musi.shop.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication //프로젝트 최상단
@EnableJpaAuditing //JPA Auditing 활성화
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
