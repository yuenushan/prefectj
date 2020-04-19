package com.example.cj.perfectj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 通过直接加@Mapper注解了。发现在写测试用例的时候，也会去扫描mapper，导致mock的时候出错
//@MapperScan("com.example.cj.perfectj.mapper")
public class PerfectjApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerfectjApplication.class, args);
    }

}
