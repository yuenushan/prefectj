package com.example.cj.perfectj.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.cj.perfectj.domain.UserDomain;
import com.example.cj.perfectj.service.UserService;

/**
 * Created on 2020-04-19
 */
@WebMvcTest(controllers = UserController.class)
class UserControllerTest2 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    void testGet() throws Exception {
        UserDomain userDomain = new UserDomain();
        userDomain.setAge(88);
        userDomain.setName("xiao ming");
        given(userService.get(100L)).willReturn(userDomain);
        mvc.perform(get("/user/100"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"status\":0,\"message\":\"success\",\"data\":{\"id\":null,"
                        + "\"name\":\"xiao ming\",\"age\":88,\"createTime\":null,\"updateTime\":null}}"));
        mvc.perform(get("/user/1001"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"status\":0,\"message\":\"success\",\"data\":null}"));
    }
}