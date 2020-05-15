package com.example.cj.perfectj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.cj.perfectj.domain.UserDomain;
import com.example.cj.perfectj.mapper.UserDomainMapper;
import com.example.cj.perfectj.service.UserService;

/**
 * Created on 2020-04-18
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDomainMapper userDomainMapper;

    @Override
    public long insert(String name, int age) {
        UserDomain userDomain = new UserDomain();
        userDomain.setName(name);
        userDomain.setAge(age);
        return insert(userDomain).getId();
    }

    @CachePut(cacheNames="user", key="#user.id")
    @Override
    public UserDomain insert(UserDomain user) {
        long now = System.currentTimeMillis();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        userDomainMapper.insert(user);
        return user;
    }

    @Cacheable(cacheNames = "user", key = "#id")
    @Override
    public UserDomain get(long id) {
        logger.info("Get User[id={}] from db", id);
        return userDomainMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(cacheNames = "user", key = "#id")
    @Override
    public void delete(long id) {
        userDomainMapper.deleteByPrimaryKey(id);
    }
}
