package com.example.cj.perfectj.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cj.perfectj.domain.OrderDomain;
import com.example.cj.perfectj.service.SecKillService;
import com.example.cj.perfectj.tool.ResponseUtil;
import com.example.cj.perfectj.tool.Response;

/**
 * Created on 2020-04-19
 */
@RestController
@RequestMapping("/seckill")
public class SecKillController {

    @Resource(name = "secKillServiceImplWrapper")
    private SecKillService secKillService;

    /**
     * @param id product表的主键id
     * @return
     */
    @PostMapping("/{id}")
    public Response secKill(@PathVariable long id) {
        OrderDomain orderDomain = secKillService.secKill(id);
        return ResponseUtil.buildSuccess(orderDomain);
    }

}
