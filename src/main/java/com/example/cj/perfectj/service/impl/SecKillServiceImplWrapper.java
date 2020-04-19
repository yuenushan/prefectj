package com.example.cj.perfectj.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.cj.perfectj.domain.OrderDomain;
import com.example.cj.perfectj.domain.ProductDomain;
import com.example.cj.perfectj.exception.PerfectjException;
import com.example.cj.perfectj.mapper.ProductDomainMapper;
import com.example.cj.perfectj.service.SecKillService;

/**
 * 装饰器模式，给SecKillServiceImpl的增加redis缓存功能
 * Created on 2020-04-19
 */
@Service
public class SecKillServiceImplWrapper implements SecKillService {

    private SecKillService secKillService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ProductDomainMapper productDomainMapper;
    private static final String REDIS_KEY_PREFIX = "PRODUCT_";

    @PostConstruct
    public void init() {
        List<ProductDomain> productDomainList = productDomainMapper.selectByExample(null);
        for (ProductDomain productDomain : productDomainList) {
            redisTemplate.opsForValue()
                    .set(getRedisKey(productDomain.getId()), String.valueOf(productDomain.getStock()));
        }
    }

    public SecKillServiceImplWrapper(@Qualifier("secKillServiceImpl") SecKillService secKillService) {
        this.secKillService = secKillService;
    }

    @Override
    public OrderDomain secKill(long productId) {
        Long decrement = redisTemplate.opsForValue().decrement(getRedisKey(productId));
        if (decrement == null) {
            throw new PerfectjException(String.format("商品id=%d不存在", productId));
        }
        if (decrement < 0) {
            throw new PerfectjException(String.format("商品id=%d已售罄", productId));
        }
        try {
            return secKillService.secKill(productId);
        } catch (Exception e) {
            redisTemplate.opsForValue().increment(getRedisKey(productId));
            throw e;
        }
    }

    private String getRedisKey(long productId) {
        return REDIS_KEY_PREFIX + productId;
    }
}
