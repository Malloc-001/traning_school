package com.sgll;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sgll.mapper")
@SpringBootApplication
public class TraningSchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraningSchApplication.class, args);
    }

}
