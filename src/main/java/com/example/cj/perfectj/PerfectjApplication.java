package com.example.cj.perfectj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.cj.perfectj.mapper")
public class PerfectjApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerfectjApplication.class, args);
    }

}
