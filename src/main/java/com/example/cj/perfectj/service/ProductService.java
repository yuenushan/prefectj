package com.example.cj.perfectj.service;

import java.math.BigDecimal;

/**
 * Created on 2020-04-19
 */
public interface ProductService {
    long addProduct(String name, int stock, BigDecimal price);
}
