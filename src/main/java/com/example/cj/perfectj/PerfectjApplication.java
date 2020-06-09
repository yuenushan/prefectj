package com.example.cj.perfectj;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
// 通过直接加@Mapper注解了。发现在写测试用例的时候，也会去扫描mapper，导致mock的时候出错
//@MapperScan("com.example.cj.perfectj.mapper")
public class PerfectjApplication implements DisposableBean {

    private final Logger logger = LoggerFactory.getLogger(PerfectjApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PerfectjApplication.class, args);
    }

    @Override
    public void destroy() {
        logger.info("application shutdown.");
    }
}
