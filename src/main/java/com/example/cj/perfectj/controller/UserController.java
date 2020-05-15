package com.example.cj.perfectj.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created on 2020-04-18
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("新建用户")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name", value = "名称")
    )
    @PostMapping("")
    public Response insert(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
//        long id = userService.insert(name, age);
        UserDomain userDomain = new UserDomain();
        userDomain.setName(name);
        userDomain.setAge(age);
        userDomain = userService.insert(userDomain);
        return ResponseUtil.buildSuccess(Collections.singletonMap("id", userDomain.getId()));
    }

    @GetMapping("/{id}")
    public Response<UserDomain> get(@PathVariable("id") long id) {
        UserDomain userDomain = userService.get(id);
        return ResponseUtil.buildSuccess(userDomain);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id")  long id) {
        userService.delete(id);
        return ResponseUtil.buildSuccess(null);
    }
}
