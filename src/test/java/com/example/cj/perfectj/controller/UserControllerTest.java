package com.example.cj.perfectj.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.cj.perfectj.tool.ResponseUtil.Response;

/**
 * Created on 2020-04-19
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void testGet() throws Exception {
        Response forObject = testRestTemplate.getForObject("/user/1", Response.class);
        System.out.println(forObject.getData());
    }
}