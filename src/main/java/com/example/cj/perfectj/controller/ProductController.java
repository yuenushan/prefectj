package com.example.cj.perfectj.controller;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cj.perfectj.exception.PerfectjException;
import com.example.cj.perfectj.service.ProductService;
import com.example.cj.perfectj.tool.ResponseUtil;
import com.example.cj.perfectj.tool.Response;
import com.example.cj.perfectj.vo.ProductVo;

/**
 * Created on 2020-04-19
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Response addProduct(@RequestBody @Valid ProductVo productVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            throw new PerfectjException(bindingResult.getAllErrors().get(0).getDefaultMessage());
            for (ObjectError error : bindingResult.getAllErrors()) {
                throw new PerfectjException(error.getDefaultMessage());
            }
        }
        long productId = productService.addProduct(productVo.getName(), productVo.getStock(), productVo.getPrice());
        return ResponseUtil.buildSuccess(Collections.singletonMap("productId", productId));
    }
}
