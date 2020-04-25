package com.example.cj.perfectj.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cj.perfectj.tool.ResponseUtil;
import com.example.cj.perfectj.tool.ResponseUtil.Response;
import com.example.cj.perfectstarter.HandsomeService;

/**
 * Created on 2020-04-17
 */
@RestController
public class HandsomeController {

    @Autowired
    private HandsomeService handsomeService;

    @GetMapping("/handsome")
    public Response handsome() {
        return ResponseUtil.buildSuccess(handsomeService.getInfo());
    }

    @GetMapping("")
    public Response index() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        return ResponseUtil.buildSuccess(addr.getHostName() + ": " + addr.getHostAddress());
    }

}
