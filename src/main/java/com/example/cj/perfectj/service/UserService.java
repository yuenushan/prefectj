package com.example.cj.perfectj.service;

import com.example.cj.perfectj.domain.UserDomain;

/**
 * Created on 2020-04-18
 */
public interface UserService {
    long insert(String name, int age);
    UserDomain insert(UserDomain user);
    UserDomain get(long id);
    void delete(long id);
}
