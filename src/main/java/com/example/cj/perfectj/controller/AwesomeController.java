package com.example.cj.perfectj.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cj.perfectj.tool.ResponseUtil;
import com.example.cj.perfectj.tool.ResponseUtil.Response;

/**
 * Created on 2020-04-17
 */
@RestController
public class AwesomeController {

    @GetMapping("/awesome")
    public Response awesome() {
        return ResponseUtil.buildSuccess("Don't ask, ask just test you awesome!");
    }

    @GetMapping("")
    public Response index() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        return ResponseUtil.buildSuccess(addr.getHostName() + ": " + addr.getHostAddress());
    }

}
