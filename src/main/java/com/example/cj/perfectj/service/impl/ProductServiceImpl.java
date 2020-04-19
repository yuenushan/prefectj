package com.example.cj.perfectj.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cj.perfectj.domain.ProductDomain;
import com.example.cj.perfectj.mapper.ProductDomainMapper;
import com.example.cj.perfectj.service.ProductService;

/**
 * Created on 2020-04-19
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDomainMapper productDomainMapper;

    @Override
    public long addProduct(String name, int stock, BigDecimal price) {
        ProductDomain productDomain = new ProductDomain();
        productDomain.setName(name);
        productDomain.setStock(stock);
        productDomain.setPrice(price);
        long now = System.currentTimeMillis();
        productDomain.setCreateTime(now);
        productDomain.setUpdateTime(now);
        productDomainMapper.insert(productDomain);
        return productDomain.getId();
    }
}
