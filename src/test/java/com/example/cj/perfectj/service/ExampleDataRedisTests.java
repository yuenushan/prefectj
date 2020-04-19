package com.example.cj.perfectj.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created on 2020-04-19
 */
@DataRedisTest
class ExampleDataRedisTests {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("hello", "world");
        assertEquals("world", redisTemplate.opsForValue().get("hello"));
    }
}
