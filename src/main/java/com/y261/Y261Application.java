package com.y261;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.y261.dao")   // 扫描 dao 包下的所有 Mapper
public class Y261Application {
    public static void main(String[] args) {
        SpringApplication.run(Y261Application.class, args);
    }
}