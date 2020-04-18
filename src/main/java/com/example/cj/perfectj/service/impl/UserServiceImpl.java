package com.example.cj.perfectj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cj.perfectj.domain.UserDomain;
import com.example.cj.perfectj.mapper.UserDomainMapper;
import com.example.cj.perfectj.service.UserService;

/**
 * Created on 2020-04-18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDomainMapper userDomainMapper;

    @Override
    public long insert(String name, int age) {
        UserDomain userDomain = new UserDomain();
        userDomain.setName(name);
        userDomain.setAge(age);
        long now = System.currentTimeMillis();
        userDomain.setCreateTime(now);
        userDomain.setUpdateTime(now);
        userDomainMapper.insert(userDomain);
        return userDomain.getId();
    }

    @Override
    public UserDomain get(long id) {
        return userDomainMapper.selectByPrimaryKey(id);
    }
}
