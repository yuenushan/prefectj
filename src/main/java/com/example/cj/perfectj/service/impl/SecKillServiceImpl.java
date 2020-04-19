package com.example.cj.perfectj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cj.perfectj.domain.OrderDomain;
import com.example.cj.perfectj.domain.ProductDomain;
import com.example.cj.perfectj.exception.PerfectjException;
import com.example.cj.perfectj.mapper.OrderDomainMapper;
import com.example.cj.perfectj.mapper.ProductDomainMapper;
import com.example.cj.perfectj.service.SecKillService;

/**
 * Created on 2020-04-19
 */
@Service
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private OrderDomainMapper orderDomainMapper;
    @Autowired
    private ProductDomainMapper productDomainMapper;

    @Override
    @Transactional
    public OrderDomain secKill(long productId) {
        ProductDomain productDomain = productDomainMapper.selectByPrimaryKey(productId);
        if (productDomain == null) {
            throw new PerfectjException(String.format("商品id=%d不存在", productId));
        }
        if (productDomain.getStock() <= 0) {
            throw new PerfectjException(String.format("商品id=%d已售罄", productId));
        }
        int decrResult = productDomainMapper.decrStock(productId);
        if (decrResult <= 0) {
            throw new PerfectjException(String.format("商品id=%d已售罄", productId));
        }
        long now = System.currentTimeMillis();
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setProductId(productDomain.getId());
        orderDomain.setAmount(productDomain.getPrice());
        orderDomain.setCreateTime(now);
        orderDomain.setUpdateTime(now);
        orderDomainMapper.insert(orderDomain);
        return orderDomain;
    }

}
