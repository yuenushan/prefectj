package com.example.cj.perfectj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cj.perfectj.domain.UserDomain;
import com.example.cj.perfectj.service.UserService;
import com.example.cj.perfectj.tool.ResponseUtil;
import com.example.cj.perfectj.tool.Response;

/**
 * Created on 2020-04-18
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public Response insert(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        long id = userService.insert(name, age);
        Map<String, Long> map = new HashMap<>();
        map.put("id", id);
        return ResponseUtil.buildSuccess(map);
    }

    @GetMapping("/{id}")
    public Response<UserDomain> get(@PathVariable("id") long id) {
        UserDomain userDomain = userService.get(id);
        return ResponseUtil.buildSuccess(userDomain);
    }
}
