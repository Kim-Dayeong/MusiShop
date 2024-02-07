package com.musi.shop.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //프로젝트 최상단
@EnableJpaAuditing //JPA Auditing 활성화
@EnableJpaRepositories("com.musi")
@EntityScan("com.musi")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
