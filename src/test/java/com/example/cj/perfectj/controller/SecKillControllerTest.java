package com.example.cj.perfectj.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created on 2020-04-19
 */
@SpringBootTest
@AutoConfigureMockMvc
class SecKillControllerTest {

    @Test
    void secKill(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(post("/seckill/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.productId").value(1));
        String content = "{\"status\":1,\"message\":\"商品id=100已售罄\",\"data\":null}";
        mvc.perform(post("/seckill/100")).andExpect(status().isOk()).andExpect(content().json(content));
    }
}