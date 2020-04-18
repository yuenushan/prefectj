package com.example.cj.perfectj.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cj.perfectj.domain.UserDomain;
import com.example.cj.perfectj.domain.UserDomainExample;

/**
 * Created on 2020-04-18
 */
@SpringBootTest
class UserDomainMapperTest {

    @Autowired
    private UserDomainMapper userDomainMapper;

    @Test
    void countByExample() {
        assertEquals(2, userDomainMapper.countByExample(null));
        UserDomainExample userDomainExample = new UserDomainExample();
        userDomainExample.createCriteria().andNameEqualTo("david");
        assertEquals(1, userDomainMapper.countByExample(userDomainExample));
    }

    @Test
    void updateByExampleSelective() {
        UserDomain userDomain = new UserDomain();
        userDomain.setAge(100);
        UserDomainExample userDomainExample = new UserDomainExample();
        userDomainExample.createCriteria().andAgeLessThan(100);
        userDomainMapper.updateByExampleSelective(userDomain, userDomainExample);
    }

}