package com.example.cj.perfectj.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.cj.perfectj.vo.ProductVo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created on 2020-04-19
 */
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Test
    void addProduct(@Autowired MockMvc mvc) throws Exception {
        ProductVo productVo = new ProductVo();
        productVo.setName("iphone x");
        productVo.setPrice(new BigDecimal(5999.0));
        productVo.setStock(100);
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(productVo);
        mvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON_VALUE).content(body))
                .andExpect(content().string("{\"status\":0,\"message\":\"success\",\"data\":{\"productId\":2}}"));
    }
}
